package com.projects.EmployeeData.repo.dao;

import com.projects.EmployeeData.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepositoryDao {
    void save(Employee employee);
    void saveAll(List<Employee> employees);
    Optional<Employee> findById(int id);
    List<Employee> findAll();
    void deleteById(int id);
    List<Employee> findByFnameOrLname(String fname, String lname);
    List<Employee> findByAge(int age);

    
}
