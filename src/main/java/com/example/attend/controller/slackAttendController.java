package com.example.attend.controller;

import com.example.attend.service.slackAttendService;
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
public class slackAttendController {

    private final slackAttendService slackAttendService;
    public slackAttendController(slackAttendService slackAttendService)
    {
        this.slackAttendService = slackAttendService;
    }

    @GetMapping("/attend/{name}")
    public String attend(@PathVariable("name") String name){
        return slackAttendService.Attend(name);
    }

    @GetMapping("/slack/{name}")
    public String send(@PathVariable("name") String name){
        return slackAttendService.Attend(name);
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
