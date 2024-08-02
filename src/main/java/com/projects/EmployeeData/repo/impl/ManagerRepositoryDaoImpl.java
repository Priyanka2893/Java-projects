package com.projects.EmployeeData.repo.impl;
import com.projects.EmployeeData.entity.Managers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepositoryDaoImpl extends JpaRepository<Managers, Integer> {

}
