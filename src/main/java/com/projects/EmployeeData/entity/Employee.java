package com.projects.EmployeeData.entity;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    private int Id;
    @Column(name = "firstName")
    private String fname;
    @Column(name = "lastName")
    private String lname;
    private int age;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age + '}';
    }
}
