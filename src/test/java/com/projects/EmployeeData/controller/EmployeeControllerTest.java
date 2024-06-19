package com.projects.EmployeeData.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.EmployeeData.entity.Employee;
import com.projects.EmployeeData.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService service;
    Employee employeeOne;
    Employee employeeTwo;
    List<Employee> employeeList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        employeeOne = Employee.build(0,"Priyanka","Shaktawat",29);
        employeeTwo = Employee.build(1,"Sanjay","Singh",35);
        employeeList.add(employeeOne);
        employeeList.add(employeeTwo);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testGetEmployeeList() throws Exception {
        when(service.getEmployeeList()).thenReturn(employeeList);
        this.mockMvc.perform(get("/employees")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetEmployeeById() throws Exception {
        when(service.getEmployeeById(1)).thenReturn(employeeOne);
        this.mockMvc.perform(get("/employee/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getEmployeeByName() throws Exception {
        when(service.getEmployeeByName("Priyanka")).thenReturn(employeeList);
        this.mockMvc.perform(get("/employeeByName/Priyanka")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getEmployeeByAge() throws Exception {
        when(service.getEmployeeByAge(29)).thenReturn(employeeList);
        this.mockMvc.perform(get("/employees/29")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void createEmployee() throws Exception {
        when(service.createEmployee(employeeOne)).thenReturn(employeeOne);
        this.mockMvc.perform(post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(employeeOne)))
                .andExpect(status().isOk());
    }
    public static String toJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void createEmployeeList() throws Exception {
        when(service.createEmployeeList(employeeList)).thenReturn(employeeList);
        this.mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(employeeList))).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateEmployee() throws Exception {
        when(service.updateEmployee(employeeTwo,1)).thenReturn(employeeTwo);
        this.mockMvc.perform(put("/employee/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(employeeTwo))).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteEmployee() throws Exception {
        when(service.deleteEmployee(1)).thenReturn("Success");
        this.mockMvc.perform(delete("/employee/1")).andDo(print()).andExpect(status().isOk());
    }
}