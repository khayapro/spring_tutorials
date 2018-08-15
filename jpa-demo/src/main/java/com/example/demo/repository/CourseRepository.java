package com.example.demo.repository;

import com.example.demo.model.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Slf4j
@Repository
@Transactional
public class CourseRepository {

    @Autowired
    private EntityManager em;

    public Course findById(final Long id) {
        return em.find(Course.class, id);
    }

    public Course save(final Course course) {
        if(course == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }

    public Course deleteById(final long id) {
        final Course response = findById(id);
        em.remove(response);
        return response;
    }


    public void functionsOfEntityManager() {
        final Course course = new Course("JPA java course");
        em.persist(course);
        course.setName("Something else");
    }
}
