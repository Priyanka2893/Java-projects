package com.projects.Java.Crud.operation;

import com.projects.Java.Crud.operation.model.Employee;
import com.projects.Java.Crud.operation.repo.EmployeeRepo;
import com.projects.Java.Crud.operation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    //READ
    @GetMapping({"employees","/"})
    public List<Employee> getAllEmployee(){
        return service.getAllEmployee();
    }

    //READ 1 employee by id
    @GetMapping("employee/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") int employeeId){
        return service.getEmployee(employeeId);
    }

    //CREATE
    @PostMapping("employee")
    public void addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
    }

    //UPDATE
    @PutMapping("employee")
    public void updateEmployee(@RequestBody Employee employee){
        service.updateEmployee(employee);
    }

    //DELETE
    @DeleteMapping("employee/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId){
        service.deleteEmployee(employeeId);
    }

    @GetMapping("load")
    public void load(){
        service.load();

    }

}
