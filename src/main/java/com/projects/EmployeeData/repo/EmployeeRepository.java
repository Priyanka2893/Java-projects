package com.projects.EmployeeData.repo;
import com.projects.EmployeeData.entity.Employee;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findByFnameOrLname(String fname,String lname);

    public List<Employee> findByAge(int age);
}
