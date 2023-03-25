package com.example.attend.service.employee;

import com.example.attend.domain.employee.Employee;
import com.example.attend.domain.employee.EmployeeRepository;
import com.example.attend.dto.JoinRequestDTO;
import com.example.attend.common.CommonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeRepository employeeRepository;


    public String join(JoinRequestDTO requestDTO) {

        String userKey = CommonUtil.makeKey(requestDTO.getEmployee().getName(),requestDTO.getEmployee().getSlackUrl());

        Employee employee = Employee.builder()
                .name(requestDTO.getEmployee().getName())
                        .slackUrl(requestDTO.getEmployee().getSlackUrl())
                                .userKey(userKey)
                                        .build();

        employeeRepository.save(employee);
        return employee.getName()+" 회원가입 완료";
    }


}
