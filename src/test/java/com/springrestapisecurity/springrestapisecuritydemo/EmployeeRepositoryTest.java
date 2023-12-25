package com.springrestapisecurity.springrestapisecuritydemo;

import com.springrestapisecurity.springrestapisecuritydemo.dao.EmployeeRepository;
import com.springrestapisecurity.springrestapisecuritydemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest
{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void saveEmployee(){
        Employee employee = Employee.builder()
                .firstName("nyakallo")
                .lastName("mashego")
                .email("nyaki@gmai.com")
                .build();

        employeeRepository.save(employee);

        assertThat(employee.getId()).isGreaterThan(0);

    }

    @Test
    public void getEmployeeTest(){

       Employee employee = employeeRepository.findById(1).get();
        assertThat(employee.getId()).isEqualTo(1);
    }

    @Test
    public  void getAllEmployeesTest(){
        List<Employee> employees = employeeRepository.findAll();
        assertThat(employees.size()).isGreaterThan(0);
    }


    @Test
    @Rollback(value = false)
    public  void updateEmployee(){
        Employee employee = employeeRepository.findById(1).get();
        employee.setEmail("tsikistiki@gmail.com");

      Employee  updatedEployee = employeeRepository.save(employee);

        assertThat(updatedEployee.getEmail()).isEqualTo("tsikistiki@gmail.com");

    }
}
