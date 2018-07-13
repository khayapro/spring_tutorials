package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager em;

    public EmployeeRepository(final EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void save(final Employee employee) {
        em.persist(employee);
    }

    public Employee findById(final long empId) {
        return em.find(Employee.class, empId);
    }

    @Transactional
    public void removeEmployee(final long id) {
        final Employee employee = findById(id);
        if(employee == null) {
            throw new IllegalArgumentException("No employee with id: " + id + " exist");
        }
        em.remove(employee);
    }

    @Transactional
    public Employee raiseEmployeeSalary(final long empId, double percentage) {
        final Employee employee = em.find(Employee.class, empId);
        if (employee == null) {
            throw new IllegalArgumentException("No employee with id: " + empId + " exist");
        }
        employee.setSalary(employee.getSalary() + (employee.getSalary() * percentage / 100));
        return employee;
    }

    public List<Employee> getAllEmployees() {
        final TypedQuery<Employee> query = em.createQuery("SELECT emp FROM Employee emp", Employee.class);
        return query.getResultList();
    }
}
