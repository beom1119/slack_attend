package com.example.attend.domain.employee;


import com.example.attend.domain.attend.Attend;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
public class Employee {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long Id;

    @Column
    private String name;

    @Column
    private int lateTime;

    @OneToMany(mappedBy = "employee")
    private List<Attend> attendList = new ArrayList<Attend>();


    @Builder
    public Employee(Long id, String name, int lateTime, List<Attend> attendList) {
        Id = id;
        this.name = name;
        this.lateTime = lateTime;
        this.attendList = attendList;
    }
}
