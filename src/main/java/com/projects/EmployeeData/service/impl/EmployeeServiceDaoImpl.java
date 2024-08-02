package com.projects.EmployeeData.service.impl;

import com.projects.EmployeeData.dto.EmployeeRequest;
import com.projects.EmployeeData.entity.Employee;
import com.projects.EmployeeData.exception.EmployeeBadRequestException;
import com.projects.EmployeeData.exception.EmployeeNotfoundException;
import com.projects.EmployeeData.exception.SuccessMessage;
import com.projects.EmployeeData.repo.impl.EmployeeRepository;
import com.projects.EmployeeData.service.dao.EmployeeServiceDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceDaoImpl implements EmployeeServiceDao {
    private final EmployeeRepository repo;

    public EmployeeServiceDaoImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    public ResponseEntity<Object> createEmployee(EmployeeRequest employeeRequest, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorsMap = result.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            return ResponseEntity.badRequest().body(errorsMap);
        }
        try {
            Employee employee = Employee.build(employeeRequest.getId(), employeeRequest.getFname(), employeeRequest.getLname(), employeeRequest.getAge());
            repo.save(employee);
            SuccessMessage<Employee> successMessage = new SuccessMessage<>(true, HttpStatus.CREATED.value(), "Successfully saved employee", employee);
            return ResponseEntity.ok(successMessage);
        } catch (Exception e) {
            throw new EmployeeBadRequestException("Please check credentials");
        }
    }

    public ResponseEntity<List<Object>> createEmployeeList(List<EmployeeRequest> list, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorsMap = result.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            return ResponseEntity.badRequest().body(Collections.singletonList(errorsMap));
        }
        try {
            List<Employee> employeeList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Employee employee = Employee.build(list.get(i).getId(), list.get(i).getFname(), list.get(i).getLname(), list.get(i).getAge());
                employeeList.add(employee);
            }
            repo.saveAll(employeeList);
            SuccessMessage<List<Employee>> successMessage = new SuccessMessage<>(true, HttpStatus.CREATED.value(), "Successfully saved employee", employeeList);
            return ResponseEntity.ok(Collections.singletonList(successMessage));
        } catch (Exception e) {
            throw new EmployeeBadRequestException("Please check credentials");
        }
    }

    public ResponseEntity<List<Object>> getEmployeeList() {
        List<Employee> employeeList = repo.findAll();
        if (employeeList.isEmpty()) {
            throw new EmployeeNotfoundException("No employee data found!");
        } else {
            SuccessMessage<List<Employee>> successMessage = new SuccessMessage<>(true, HttpStatus.OK.value(), "Successfully retrieved employees", employeeList);
            return ResponseEntity.ok(Collections.singletonList(successMessage));
        }
    }

    public ResponseEntity<Object> getEmployeeById(int id) {
        Optional<Employee> employee = repo.findById(id);
        if (employee.isEmpty()) {
            throw new EmployeeNotfoundException("No employee found of id " + id);
        } else {
            SuccessMessage<Employee> successMessage = new SuccessMessage<>(true, HttpStatus.OK.value(), "Successfully retrieved employee", employee.get());
            return ResponseEntity.ok(successMessage);
        }
    }

    public ResponseEntity<Object> updateEmployee(int id, Employee employee) {

        Optional<Employee> employeeUpdate = repo.findById(id);

        if (employeeUpdate.isPresent()) {
            Employee employee1 = employeeUpdate.get();
            employee1.setFname(employee.getFname());
            employee1.setLname(employee.getLname());
            employee1.setAge(employee.getAge());
            repo.save(employee1);
            SuccessMessage<Employee> successMessage = new SuccessMessage<>(true, HttpStatus.OK.value(), "Successfully updated employee", employee1);
            return ResponseEntity.ok(successMessage);
        } else {
            throw new EmployeeNotfoundException("No employee with id " + id + " found");
        }
    }

    public ResponseEntity<Object> partialUpdateEmployee(int id, Employee employee) {
        Optional<Employee> employeeUpdate = repo.findById(id);

        if (employeeUpdate.isPresent()) {
            Employee employee1 = employeeUpdate.get();
            System.out.println(employee.getFname());
            if (employee.getFname() != null) {
                employee1.setFname(employee.getFname());
            }
            if (employee.getLname() != null) {
                employee1.setLname(employee.getLname());
            }
            if (employee.getAge() != 0) {
                employee1.setAge(employee.getAge());
            }
            repo.save(employee1);
            SuccessMessage<Employee> successMessage = new SuccessMessage<>(true, HttpStatus.OK.value(), "Successfully updated employee", employee1);
            return ResponseEntity.ok(successMessage);
        } else {
            throw new EmployeeNotfoundException("No employee with id " + id + " found");
        }
    }

    public ResponseEntity<Object> deleteEmployee(int id) {
        Optional<Employee> employee = repo.findById(id);
        if (employee.isPresent()) {
            Employee employee1 = employee.get();
            repo.deleteById(id);
            SuccessMessage<Employee> successMessage = new SuccessMessage<>(true, HttpStatus.OK.value(), "Successfully deleted employee", employee1);
            return ResponseEntity.ok(successMessage);
        } else {
            throw new EmployeeNotfoundException("No employee with id " + id + " found");
        }
    }

    public ResponseEntity<List<Object>> getEmployeeByName(String name) {
        name = capitalizeFirstLetter(name);
        List<Employee> employeeList = repo.findByFnameOrLname(name, name);
        if (employeeList.isEmpty()) {
            throw new EmployeeNotfoundException("No employee with name " + name + " found");
        } else {
            SuccessMessage<List<Employee>> successMessage = new SuccessMessage<>(true, HttpStatus.OK.value(), "Successfully retrieved employees", employeeList);
            return ResponseEntity.ok(Collections.singletonList(successMessage));
        }
    }

    private String capitalizeFirstLetter(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public ResponseEntity<List<Object>> getEmployeeByAge(int age) {
        List<Employee> employeeList = repo.findByAge(age);
        if (employeeList.isEmpty()) {
            throw new EmployeeNotfoundException("No employee with age " + age + " found");
        } else {
            SuccessMessage<List<Employee>> successMessage = new SuccessMessage<>(true, HttpStatus.OK.value(), "Successfully retrieved employees", employeeList);
            return ResponseEntity.ok(Collections.singletonList(successMessage));
        }
    }
}
