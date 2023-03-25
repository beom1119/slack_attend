package com.example.attend.dto;

import com.example.attend.domain.employee.Employee;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
public class JoinRequestDTO {


    private EmployeeDTO employee;


    @Builder
    public JoinRequestDTO(EmployeeDTO employeeDTO) {
        this.employee = employeeDTO;
    }



    @Getter
    @NoArgsConstructor
    public static class EmployeeDTO{

        private String name;
        private String slackUrl;


        @Builder
        public EmployeeDTO(String name, String slackUrl) {
            this.name = name;
            this.slackUrl = slackUrl;
        }
    }

}





