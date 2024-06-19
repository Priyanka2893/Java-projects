package com.projects.EmployeeData.controller;
import com.projects.EmployeeData.dto.EmployeeRequest;
import com.projects.EmployeeData.entity.Employee;
import com.projects.EmployeeData.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@Controller
@RequestMapping("/employee/v1")
public class EmployeeController {
    private static final Logger logInfo = LoggerFactory.getLogger(EmployeeController.class);
    private EmployeeService service;
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<Object>> getEmployeeList(){
        return service.getEmployeeList();
    }
    @GetMapping(value = "/",params = "id")
    public ResponseEntity<Object> getEmployeeById(@RequestParam int id){
         return service.getEmployeeById(id);
    }
    @GetMapping(value = "/",params = "name")
    public ResponseEntity<List<Object>> getEmployeeByName(@RequestParam String name){
        return service.getEmployeeByName(name);
    }

    @GetMapping(value = "/",params = "age")
    public ResponseEntity<List<Object>> getEmployeeByAge(@RequestParam int age){
        return service.getEmployeeByAge(age);
    }

    @PostMapping("/")
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest,BindingResult result){
        return service.createEmployee(employeeRequest,result);
    }
    @PostMapping("/employees")
    public ResponseEntity<List<Object>> createEmployeeList(@RequestBody @Valid List<EmployeeRequest> employeesRequest,BindingResult result){
        return service.createEmployeeList(employeesRequest,result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable("id") int id,@RequestBody @Valid Employee employee){
        return service.updateEmployee(id,employee);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id){
        return service.deleteEmployee(id);
    }
}
