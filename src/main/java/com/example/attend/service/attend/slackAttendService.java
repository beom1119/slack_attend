package com.example.attend.service.attend;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
public class slackAttendService {





    String dmUrl ="";





    public String dmAttend(String name)
    {
        RestTemplate restTemplate = new RestTemplate();
        LocalDateTime startTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Map<String, Object> request = new HashMap<>();
        request.put("username", "출석 체크");
        request.put("text", "*" + name + "*" + " 출근 " + startTime.getHour() + ":" + startTime.getMinute() + "," +
                "  퇴근" + startTime.plusHours(9).getHour() + ":" + startTime.getMinute());
        HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(request);
        dmUrl = userUrl(name); //슬랙 URL 넣기

        if (dmUrl.equals("")) {
            return "등록되지 않은 사용자";
        } else {
            restTemplate.exchange(dmUrl, HttpMethod.POST, entity, String.class);
            return name + " 출근";
        }
    }


    public String attend(String name)
    {
        RestTemplate restTemplate = new RestTemplate();
        LocalDateTime startTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

//        if (startTime.getHour()>10)
//        {
//            return "지각"; }
//        else {
        Map<String,Object> request = new HashMap<>();
        request.put("username", "출석 체크");
        request.put("text", "*"+name+"*" + " 출근 "+startTime.getHour()+ ":" +startTime.getMinute() + "," +
                "  퇴근"+startTime.plusHours(9).getHour()+":"+startTime.getMinute());
        HttpEntity<Map<String,Object>> entity = new HttpEntity<Map<String,Object>>(request);
        // 사용할 슬랙의 Webhook URL 넣기
        restTemplate.exchange("https://hooks.slack.com/services/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", HttpMethod.POST, entity, String.class);
        return name+" 출근"; }
//    }


    public String userUrl(String name)
    {
//        if (name.equals("kobe") || name.equals("beom"))
//        {
//            dmUrl = kobeKey;
//        } else if (name.equals("samuel")) {
//            dmUrl = samuelKey;
//        }else if (name.equals("linzy")) {
//            dmUrl = linzyKey;
//        }else if (name.equals("brody")) {
//            dmUrl = brodyKey;
//        }
//        else if (name.equals("zeri")) {
//            dmUrl = zeriKey;
//        }
//        else if (name.equals("steve")) {
//            dmUrl = steveKey;
//        }else
//        {
//            dmUrl ="";
//        }
        return dmUrl;
    }

}
