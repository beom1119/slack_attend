package com.example.attend.controller;

import com.example.attend.dao.UserMapper;
import com.example.attend.dto.user;
import com.example.attend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class userController {

    private final UserService userService;

    @GetMapping("/userhello")
    public String userHello()
    {
        return "hello";
    }


    @GetMapping("/getuser")
    public List<user> getuser()
    {
       return userService.getUserList();
    }


}
