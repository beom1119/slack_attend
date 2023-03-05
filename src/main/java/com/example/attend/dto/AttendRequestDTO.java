package com.example.attend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
public class AttendRequestDTO {


    private AttendDTO attend;

    private EmployeeDTO employee;


    @Builder
    public AttendRequestDTO(AttendDTO attend, EmployeeDTO employee) {
        this.attend = attend;
        this.employee = employee;
    }

    @Getter
    @NoArgsConstructor
    public static class AttendDTO {

        private LocalDateTime startTime;

        @Builder
        public AttendDTO(LocalDateTime startTime) {
            this.startTime = startTime;
        }




    }

    @Getter
    @NoArgsConstructor
    public static class EmployeeDTO {

        private String name;

        @Builder
        public EmployeeDTO(String name) {
            this.name = name;
        }
    }



}





