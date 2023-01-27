package com.example.attend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class slackAttendController {

    @Value("${slack.url}")
    String url;

    @Value("${slack.channel}")
    String channel;


    @GetMapping("/slack/{name}")
    public String send(@PathVariable("name") String name){
        RestTemplate restTemplate = new RestTemplate();
        LocalDateTime startTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Map<String,Object> request = new HashMap<>();
        request.put("username", "출석 체크");
        request.put("text", "*"+name+"*" + " 출근 "+startTime.getHour()+ ":" +startTime.getMinute() + "," +
                "  퇴근"+startTime.plusHours(9).getHour()+":"+startTime.getMinute());
        HttpEntity<Map<String,Object>> entity = new HttpEntity<Map<String,Object>>(request);
        // 사용할 슬랙의 Webhook URL 넣기
        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return "hello";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return name;
    }

    @GetMapping("/hello2")
    public String hello(){
        return "hello2";
    }

}
