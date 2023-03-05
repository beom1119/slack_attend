package com.example.attend.service.attend;


import com.example.attend.domain.attend.Attend;
import com.example.attend.domain.attend.AttendRepository;
import com.example.attend.domain.employee.Employee;
import com.example.attend.domain.employee.EmployeeRepository;
import com.example.attend.dto.AttendRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendService {


    private final AttendRepository attendRepository;
    private final EmployeeRepository employeeRepository;


    public String attend(Long id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(IllegalArgumentException::new);


        Attend attend = Attend.builder()
                .startTime(LocalDateTime.now())
                .employee(employee)
                .build();

        attendRepository.save(attend);
        return String.format("%s 출석 완료",employee.getName());
    }







}
