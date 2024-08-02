package com.projects.EmployeeData.service.dao;

import com.projects.EmployeeData.dto.EmployeeRequest;
import com.projects.EmployeeData.entity.Employee;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceDao {
    // Save a single employee
    ResponseEntity<Object> createEmployee(EmployeeRequest employeeRequest, BindingResult result);
    ResponseEntity<List<Object>> createEmployeeList(List<EmployeeRequest> list,BindingResult result);
    ResponseEntity<List<Object>> getEmployeeList();
    ResponseEntity<Object> getEmployeeById(int id);
    ResponseEntity<Object> updateEmployee(int id,Employee employee);
    ResponseEntity<Object> partialUpdateEmployee(int id, Employee employee);
    ResponseEntity<Object> deleteEmployee(int id);
    ResponseEntity<List<Object>> getEmployeeByName(String name);
    ResponseEntity<List<Object>> getEmployeeByAge(int age);
}
