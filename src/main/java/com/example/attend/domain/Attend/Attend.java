package com.example.attend.domain.Attend;


import com.example.attend.domain.Employee.Employee;

import javax.persistence.*;

@Entity
public class Attend {

    @Id
    private Long Id;

    @ManyToOne
    @Column
    private Employee employee;

}
