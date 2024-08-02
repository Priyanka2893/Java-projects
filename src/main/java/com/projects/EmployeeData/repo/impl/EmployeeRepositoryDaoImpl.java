//package com.projects.EmployeeData.repo.impl;
//import com.projects.EmployeeData.entity.Employee;
//import com.projects.EmployeeData.repo.dao.EmployeeRepositoryDao;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@Component
//public class EmployeeRepositoryDaoImpl implements EmployeeRepositoryDao {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//    @Override
//    public void save(Employee employee) {
//        Session session = sessionFactory.getCurrentSession();
//        session.saveOrUpdate(employee);
//    }
//
//    @Override
//    public void saveAll(List<Employee> employees) {
//        Session session = sessionFactory.getCurrentSession();
//        for (Employee employee : employees) {
//            session.saveOrUpdate(employee);
//        }
//    }
//
//    @Override
//    public Optional<Employee> findById(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        Employee employee = session.get(Employee.class, id);
//        return Optional.ofNullable(employee);
//
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("from Employee", Employee.class).list();
//    }
//
//    @Override
//    public void deleteById(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        Employee employee = session.byId(Employee.class).load(id);
//        session.delete(employee);
//    }
//
//    @Override
//    public List<Employee> findByFnameOrLname(String fname, String lname) {
//        Session session = sessionFactory.getCurrentSession();
//        Query<Employee> query = session.createQuery("from Employee where fname = :fname or lname = :lname", Employee.class);
//        query.setParameter("fname", fname);
//        query.setParameter("lname", lname);
//        return query.list();
//    }
//
//    @Override
//    public List<Employee> findByAge(int age) {
//        Session session = sessionFactory.getCurrentSession();
//        Query<Employee> query = session.createQuery("from Employee where age = :age", Employee.class);
//        query.setParameter("age", age);
//        return query.list();
//    }
//
//}
