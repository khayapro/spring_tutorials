package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Test
    @DirtiesContext
    public void should_save_employee() {
        final Employee employee = saveEmployee();
        assertThat(employee.getId()).isNotNull();
        assertThat(employee.getName()).isEqualTo("Sam");
    }

    @Test
    @DirtiesContext
    public void should_save_and_find_employee() {
        final Employee employee = saveEmployee();
        final Employee response = repository.findById(employee.getId());
        assertThat(response).isNotNull();
        assertThat(response.getName()).isEqualTo("Sam");
    }

    @Test
    @DirtiesContext
    public void should_remove_employee() {
        final Employee employee = saveEmployee();
       repository.removeEmployee(employee.getId());
        final Employee response = repository.findById(employee.getId());
        assertThat(response).isNull();
    }

    @Test
    @DirtiesContext
    public void should_get_all_employees () {
        final Employee employee = saveEmployee();
        final List<Employee> allEmployees = repository.getAllEmployees();
        allEmployees.forEach(emp -> {
            assertThat(emp.getName()).isEqualTo(employee.getName());
            assertThat(emp.getId()).isEqualTo(employee.getId());
            assertThat(emp.getSalary()).isEqualTo(employee.getSalary());
        });
    }

    @Test
    @DirtiesContext
    public void should_raise_employee_salary () {
        Employee employee = saveEmployee();
        employee = repository.raiseEmployeeSalary(employee.getId(), 10);
        assertThat(employee.getSalary()).isEqualTo(11000d);
        //confirming that the salary change has been persisted successfully
        final Employee response = repository.findById(employee.getId());
        assertThat(response.getSalary()).isEqualTo(11000d);

    }

    private static Employee getEmployeeInstance() {
        final Employee employee = new Employee();
        employee.setName("Sam");
        employee.setSalary(10000d);
        return employee;
    }

    private Employee saveEmployee() {
        final Employee employee = getEmployeeInstance();
        repository.save(employee);
        return employee;
    }
}