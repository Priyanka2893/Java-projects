//package com.projects.EmployeeData.repo;
//
//import com.projects.EmployeeData.entity.Employee;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
////import static org.assertj.core.api.Assertions.assertThat;
//
//
//
//import java.util.List;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
//public class EmployeeRepositoryTest {
//    @Autowired
//    private EmployeeRepositoryImpl repo;
//    Employee employee;
//
//    // test cases
//
//
//    @BeforeEach
//    void setUp() {
//        employee = new Employee("Harshit","Rathore",33);
//        repo.save(employee);
//    }
//
//    @AfterEach
//    void tearDown() {
//        employee = null;
//        repo.deleteAll();
//    }
//
//    @Test
//    void testFindByFnameOrLname_Found(){
//        List<Employee> employees = repo.findByFnameOrLname("harshit","Rathore");
////        assertEquals("Harshit", employees.get(0).getFname());
//        assertThat(employees.get(0).getFname()).isEqualTo(employee.getFname());
//
//    }
//
//    @Test
//    void testFindByFnameOrLname_Not_Found(){
//        List<Employee> employees = repo.findByFnameOrLname("komal","mahajan");
//        assertThat(employees.isEmpty()).isTrue();
//    }
//}
