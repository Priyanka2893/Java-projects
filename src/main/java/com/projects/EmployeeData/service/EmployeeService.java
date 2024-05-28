package com.projects.EmployeeData.service;

import com.projects.EmployeeData.entity.Employee;
import com.projects.EmployeeData.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public Employee createEmployee(Employee employee){
        return repo.save(employee);
    }
    public List<Employee> createEmployeeList(List<Employee> list) {
        return repo.saveAll(list);
    }
    public List<Employee> getEmployeeList(){
        return repo.findAll();
    }
    public Employee getEmployeeById(int id){
        return repo.findById(id).orElse(null);

    }
    public Employee updateEmployee(Employee employee,int id){
        Optional<Employee> employeeUpdate = repo.findById(id);
        if(employeeUpdate.isPresent()) {
            Employee employee1 = employeeUpdate.get();
            employee1.setFname(employee.getFname());
            employee1.setLname(employee.getLname());
            employee1.setAge(employee.getAge());

            return repo.save(employee1);
        }
        return null;
    }
    public String deleteEmployee(int id){
        repo.deleteById(id);
        return "Employee" + id + "deleted";
    }

    public List<Employee> getEmployeeByName(String name) {
        name = capitalizeFirstLetter(name);
        return repo.findByFnameOrLname(name,name);
    }
    private String capitalizeFirstLetter(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public List<Employee> getEmployeeByAge(int age){
        return repo.findByAge(age);
    }
}
