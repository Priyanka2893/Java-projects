package com.projects.EmployeeData.repo;

import com.projects.EmployeeData.entity.Managers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Managers,Integer> {

}
