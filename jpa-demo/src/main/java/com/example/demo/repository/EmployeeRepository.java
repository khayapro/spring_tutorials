package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(final Employee employee) {
        em.persist(employee);
    }

    public Employee findById(final long empId) {
        return em.find(Employee.class, empId);
    }
}
