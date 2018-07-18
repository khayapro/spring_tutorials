package com.example.demo.repository;

import com.example.demo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CourseRepository {

    @Autowired
    private EntityManager em;

    public Course findById(final Long id) {
        return em.find(Course.class, id);
    }

    public Course save(final Course course) {
        return null;
    }
}
