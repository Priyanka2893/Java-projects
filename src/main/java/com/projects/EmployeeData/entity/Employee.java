package com.projects.EmployeeData.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "employee")
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data // getters setters contructors
public class Employee implements Serializable {
    @Id
    @GeneratedValue
    private int Id;
    @Column(name = "firstName")
    private String fname;
    @Column(name = "lastName")
    private String lname;
    private int age;

}
