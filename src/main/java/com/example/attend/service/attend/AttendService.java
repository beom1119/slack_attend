package com.example.attend.service.attend;


import com.example.attend.domain.attend.Attend;
import com.example.attend.domain.attend.AttendRepository;
import com.example.attend.domain.employee.Employee;
import com.example.attend.domain.employee.EmployeeRepository;
import com.example.attend.dto.AttendRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendService {


    private final AttendRepository attendRepository;
    private final EmployeeRepository employeeRepository;


    public String attend(String userKey) {

        Employee employee = employeeRepository.findByUserKey(userKey).orElseThrow(IllegalArgumentException::new);



            RestTemplate restTemplate = new RestTemplate();
            LocalDateTime startTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
            Map<String, Object> request = new HashMap<>();
            request.put("username", "출석 체크");
            request.put("text", "*" + employee.getName() + "*" + " 출근 " + startTime.getHour() + ":" + startTime.getMinute() + "," +
                    "  퇴근" + startTime.plusHours(9).getHour() + ":" + startTime.getMinute());
            HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(request);
             String dmUrl = employee.getSlackUrl(); //슬랙 URL 넣기

        if (dmUrl.equals("")) {
                return "등록되지 않은 사용자";
            } else {
                restTemplate.exchange(dmUrl, HttpMethod.POST, entity, String.class);
                return employee.getName() + " 출근";
            }
    }







}
