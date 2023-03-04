package com.example.attend.domain.Employee;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Employee {


    @Id
    private Long Id;

    @Column
    private String name;

    @Column
    private int lateTime;



}
