package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.DAO.EmployeeDAO;
import com.luv2code.springboot.cruddemo.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAllEmployees(){
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee ORDER BY id", Employee.class);
        List<Employee> employees =  query.getResultList();
        return employees;
    }

    @Override
    public Employee getEmployeeByID(int Id) {
        Employee employee = entityManager.find(Employee.class, Id);
        return employee;
    }

    @Override
    public void deleteAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        entityManager.remove(query.getResultList());
    }

    @Override
    public void deleteEmployeeByID(int Id) {
        Employee emp = entityManager.find(Employee.class, Id);
        entityManager.remove(emp);
    }

    @Override
    public Employee save(Employee employee) {
        Employee emp = entityManager.merge(employee);
        return emp;
    }

}
