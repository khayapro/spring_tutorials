package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Test
    public void should_save_employee() {
        final Employee employee = new Employee();
        employee.setName("Sam");
        employee.setSalary(10000d);
        repository.save(employee);
        assertThat(employee.getId()).isNotNull();
    }

    @Test
    public void should_save_and_find_employee() {
        final Employee response = repository.findById(1L);
        assertThat(response).isNotNull();
        assertThat(response.getName()).isEqualTo("Sam");
    }

    @Test
    public void should_remove_employee() {
        final Employee employee = new Employee();
        repository.removeEmployee(employee);
    }
}