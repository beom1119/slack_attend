package com.example.attend.controller.attend;


import com.example.attend.dto.AttendRequestDTO;
import com.example.attend.service.attend.AttendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AttendController {

    private final AttendService attendService;


    @GetMapping("/slack/test")
    public String test()
    {
        return "test";
    }

    @GetMapping("/slack/attend/{userKey}")
    public String attend(@PathVariable String userKey)
    {
        return attendService.attend(userKey);
    }

}
