package com.projects.EmployeeData.repo;
import com.projects.EmployeeData.entity.Employee;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findByFnameOrLname(String fname,String lname);

    public List<Employee> findByAge(int age);
}
