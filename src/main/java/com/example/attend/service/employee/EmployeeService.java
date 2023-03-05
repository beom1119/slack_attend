package com.example.attend.service.employee;

import com.example.attend.domain.employee.Employee;
import com.example.attend.domain.employee.EmployeeRepository;
import com.example.attend.dto.JoinRequestDTO;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeRepository employeeRepository;


    public String join(JoinRequestDTO requestDTO) {




        Employee employee = Employee.builder()
                .name(requestDTO.getEmployee().getName())
                .build();

        employeeRepository.save(employee);
        return employee.getName()+"회원가입 완료";
    }


}
