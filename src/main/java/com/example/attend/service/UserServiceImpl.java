package com.example.attend.service;

import com.example.attend.dao.UserMapper;
import com.example.attend.dto.user;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;

    @Override
    public List<user> getUserList() {
        return userMapper.getUserList();
    }
}
