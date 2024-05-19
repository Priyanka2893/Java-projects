package com.projects.Java.Crud.operation.service;

import com.projects.Java.Crud.operation.model.Employee;
import com.projects.Java.Crud.operation.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo repo;

    public void load() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Priyanka Shaktawat", 31, "Backend",
                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));
        employees.add(new Employee(2, "Sanjay Singh", 33,
                "Frontend", List.of("HTML", "CSS", "JavaScript", "React")));
        employees.add(new Employee(3, "Soni Chahal", 29, "Backend",
                List.of("Python", "Machine Learning", "Data Analysis")));
        employees.add(new Employee(4, "Rama Todwal", 29, "Frontend",
                List.of("Networking", "Cisco", "Routing", "Switching")));
        repo.saveAll(employees);
    }
    public List<Employee> getAllEmployee() {
        return repo.findAll();
    }

    public Employee getEmployee(int employeeId) {
        return repo.findById(employeeId).orElse(new Employee());
    }

    public void addEmployee(Employee employee) {
        repo.save(employee);
    }

    public void updateEmployee(Employee employee) {
        repo.save(employee);
    }

    public void deleteEmployee(int employeeId) {
        repo.deleteById(employeeId);
    }
}
