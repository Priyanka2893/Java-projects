package com.projects.EmployeeData.service;

import com.projects.EmployeeData.entity.Managers;
import com.projects.EmployeeData.repo.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository repo;

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
