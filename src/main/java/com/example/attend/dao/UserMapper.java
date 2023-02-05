package com.example.attend.dao;

import com.example.attend.dto.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<user> getUserList();
}
