package com.example.attend.domain.attend;


import com.example.attend.domain.employee.Employee;
import com.example.attend.dto.AttendRequestDTO;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Attend {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private int workTime;


    @Builder
    public Attend(Long id, Employee employee, LocalDateTime startTime, LocalDateTime endTime, int workTime) {
        Id = id;
        this.employee = employee;
        this.startTime = startTime;
        this.endTime = endTime;
        this.workTime = workTime;
    }


    public static Attend valueOf(AttendRequestDTO requestDTO)
    {
        Attend attend = Attend.builder()
                        .startTime(requestDTO.getAttend().getStartTime())
                                .build();
        return attend;
    }



}
