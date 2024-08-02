package com.projects.EmployeeData.service.impl;

import com.projects.EmployeeData.entity.Managers;
import com.projects.EmployeeData.repo.impl.ManagerRepositoryDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceDaoImpl {

    private ManagerRepositoryDaoImpl repo;
    public ManagerServiceDaoImpl(ManagerRepositoryDaoImpl repo){
        this.repo = repo;
    }

    public List<Managers> getManagerList() {
        return repo.findAll();

    }

    public void createManagers(List<Managers> managers) {
        repo.saveAll(managers);
    }

    public void createManager(Managers manager) {
        repo.save(manager);
    }

}
