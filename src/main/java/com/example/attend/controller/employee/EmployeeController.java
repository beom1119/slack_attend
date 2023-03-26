package com.example.attend.controller.employee;


import com.example.attend.domain.employee.Employee;
import com.example.attend.dto.JoinRequestDTO;
import com.example.attend.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {


    private final EmployeeService employeeService;

    @PostMapping("/slack/join")
    public String join(@RequestBody JoinRequestDTO requestDTO)
    {
        return employeeService.join(requestDTO);
    }
}
