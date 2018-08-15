package com.example.demo.repository;

import com.example.demo.DemoApplication;
import com.example.demo.model.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void findById() {
        final Course response = repository.findById(1L);
        assertThat(response).isNotNull();
    }

    @Test
    @DirtiesContext
    public void save() {
        final Course response = repository.save(getInstance());
        assertThat(response).isNotNull();
    }

    @Test
    public void saveAndUpdate() {
        final Course course = repository.findById(1L);
        course.setName(course.getName() + " merged");
        repository.save(course);
        final Course result = repository.findById(1L);
        assertThat(result.getName()).isEqualTo(course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteCourse() {
        final Course course = repository.deleteById(100L);
        final Course result = repository.findById(100L);
        assertThat(result).isNull();
    }

    @Test
    @DirtiesContext
    public void testingEntityManager() {
        repository.functionsOfEntityManager();
    }



    public static Course getInstance() {
        return new Course("Learning Artificial Intelligence");
    }
}