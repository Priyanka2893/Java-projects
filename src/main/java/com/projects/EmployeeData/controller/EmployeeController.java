package com.projects.EmployeeData.controller;

import com.projects.EmployeeData.entity.Employee;
import com.projects.EmployeeData.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@ResponseBody
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @GetMapping("/employees")
    public List<Employee> getEmployeeList(){
        return service.getEmployeeList();
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return service.getEmployeeById(id);
    }
    @GetMapping("/employeeByName/{name}")
    public List<Employee> getEmployeeByName(@PathVariable("name") String name){
        return service.getEmployeeByName(name);
    }
    @GetMapping("/employees/{age}")
    public List<Employee> getEmployeeByAge(@PathVariable("age") int age){
        return service.getEmployeeByAge(age);
    }
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return service.createEmployee(employee);
    }
    @PostMapping("/employees")
    public List<Employee> createEmployeeList(@RequestBody List<Employee> employees){
        return service.createEmployeeList(employees);
    }
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee){
        return service.updateEmployee(employee,id);
    }
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        return service.deleteEmployee(id);
    }
}
