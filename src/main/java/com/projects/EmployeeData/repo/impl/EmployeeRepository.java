package com.projects.EmployeeData.repo.impl;

import com.projects.EmployeeData.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFnameOrLname(String name, String name1);

    List<Employee> findByAge(int age);
}
