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
        return slackAttendService.attend(name);
    }

    @GetMapping("/attend/dm/{name}")
    public String dmattend(@PathVariable("name") String name){
        return slackAttendService.dmAttend(name);
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
