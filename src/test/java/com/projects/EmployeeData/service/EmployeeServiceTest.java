package com.projects.EmployeeData.service;

import com.projects.EmployeeData.dto.EmployeeRequest;
import com.projects.EmployeeData.entity.Employee;
import com.projects.EmployeeData.repo.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repo;
    @InjectMocks
    private EmployeeService service;
    AutoCloseable autoCloseable;
    EmployeeRequest employeeRequest1;
    EmployeeRequest employeeRequest2;
    List<EmployeeRequest> employeeRequestList = new ArrayList<>();
    Employee employeeOne;
    Employee employeeTwo;
    List<Employee> employeeList = new ArrayList<>();
    BindingResult result;
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        employeeOne = Employee.build(0,"Priyanka","Shaktawat",29);
        employeeTwo = Employee.build(1,"Sanjay","Singh",35);
        employeeList.add(employeeOne);
        employeeList.add(employeeTwo);
        employeeRequest1 = EmployeeRequest.build(0,"Priyanka","Shaktawat",29);
        employeeRequest2 = EmployeeRequest.build(1,"Sanjay","Singh",35);
        employeeRequestList.add(employeeRequest1);
        employeeRequestList.add(employeeRequest2);


    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateEmployee() {
        when(repo.save(Mockito.any())).thenReturn(employeeRequest1);
        assertThat(service.createEmployee(employeeRequest1,result)).isEqualTo(employeeRequest1);
    }

    @Test
    void createEmployeeList() {
        when(repo.saveAll(employeeList)).thenReturn(employeeList);
        List<Employee> savedEmployees = service.createEmployeeList(employeeRequestList,result);
        assertNotNull(savedEmployees);
        assertEquals(employeeList.size(), savedEmployees.size());
    }

    @Test
    void testUpdateEmployee() {
//        when(repo.save(employee)).thenReturn(employee);
//        assertThat(service.updateEmployee(employee,0)).isEqualTo(employee);

        int id = 1;
        Employee existingEmployee = new Employee("mohit","gupta",27);
        Employee updatedEmployee = new Employee("monica","sharma",33);

        when(repo.findById(id)).thenReturn(Optional.of(existingEmployee));
        when(repo.save(existingEmployee)).thenReturn(updatedEmployee);

        Employee result = service.updateEmployee(updatedEmployee, id);

        assertNotNull(result);
        assertEquals(updatedEmployee, result);
    }
    @Test
    void getEmployeeList() {
        when(repo.findAll()).thenReturn(new ArrayList<Employee>(Collections.singleton(employeeTwo)));
        assertThat(service.getEmployeeList().get(0).getId()).isEqualTo(employeeTwo.getId());
    }

    @Test
    void getEmployeeById() {
        when(repo.findById(1)).thenReturn(Optional.ofNullable(employeeOne));
        assertThat(service.getEmployeeById(1).getFname()).isEqualTo(employeeOne.getFname());
    }
    @Test
    void getEmployeeByName() {
        String name = "raja";
        String capitalizedName = "Raja";
        when(repo.findByFnameOrLname(capitalizedName, capitalizedName)).thenReturn(employeeList);
        List<Employee> foundEmployees = service.getEmployeeByName(name);
        assertNotNull(foundEmployees);
        assertEquals(employeeList.size(), foundEmployees.size());

//        when(repo.findByFnameOrLname("Raja","Hindustani")).thenReturn(new ArrayList<Employee>(Collections.singleton(employee)));
//        assertThat(service.getEmployeeByName("raja").get(0).getId()).isEqualTo(employee.getId());
    }

    @Test
    void getEmployeeByAge() {
        when(repo.findByAge(35)).thenReturn(new ArrayList<Employee>(Collections.singleton(employeeTwo)));
        assertThat(service.getEmployeeByAge(35).get(0).getId()).isEqualTo(employeeTwo.getId());
    }
    @Test
    void deleteEmployee() {
        doAnswer(Answers.CALLS_REAL_METHODS).when(repo).deleteById(anyInt());
        assertThat(service.deleteEmployee(1)).isEqualTo("Success");

    }

}