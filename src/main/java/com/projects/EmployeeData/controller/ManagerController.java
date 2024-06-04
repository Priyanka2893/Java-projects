package com.projects.EmployeeData.controller;

import com.projects.EmployeeData.entity.Managers;
import com.projects.EmployeeData.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Controller
public class ManagerController {
    @Autowired
    private ManagerService service;

    @GetMapping("/managers")
    public List<Managers> getManagerList(){
        return service.getManagerList();
    }

    @PostMapping("/managers")
    public void createManagers(@RequestBody List<Managers> managers){
        service.createManagers(managers);
    }

    @PostMapping("/manager")
    public void createManager(@RequestBody Managers manager){
        service.createManager(manager);
    }

}
