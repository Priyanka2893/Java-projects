package com.projects.Java.Crud.operation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class Employee {
    @Id
    private int employeeId;
    private String name;
    private int age;
    private String department;
    private List<String> techKnown;

}
