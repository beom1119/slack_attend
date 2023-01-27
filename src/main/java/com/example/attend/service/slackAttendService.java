package com.example.attend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@Service
public class slackAttendService {

    @Value("${slack.url}")
    String url;

    @Value("${slack.channel}")
    String channel;
    public String Attend(String name)
    {
        RestTemplate restTemplate = new RestTemplate();
        LocalDateTime startTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Map<String,Object> request = new HashMap<>();
        request.put("username", "출석 체크");
        request.put("text", "*"+name+"*" + " 출근 "+startTime.getHour()+ ":" +startTime.getMinute() + "," +
                "  퇴근"+startTime.plusHours(9).getHour()+":"+startTime.getMinute());
        HttpEntity<Map<String,Object>> entity = new HttpEntity<Map<String,Object>>(request);
        // 사용할 슬랙의 Webhook URL 넣기
        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return name+" 출근";
    }



}
