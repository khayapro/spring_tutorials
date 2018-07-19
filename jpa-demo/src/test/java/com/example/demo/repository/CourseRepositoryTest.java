package com.example.demo.repository;

import com.example.demo.DemoApplication;
import com.example.demo.model.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
        assertThat(response.getName()).isEqualTo("Learning JPA");
    }

    @Test
    public void deleteCourse() {
        final Course response = repository.deleteById(1L);
        assertThat(response).isNull();
    }

    @Test
    public void save() {
    }
}