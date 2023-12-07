package com.springrestapisecurity.springrestapisecuritydemo.service;

import com.springrestapisecurity.springrestapisecuritydemo.dao.EmployeeRepository;
import com.springrestapisecurity.springrestapisecuritydemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{
private EmployeeRepository employeeRepository;


   @Autowired
   public  EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
    employeeRepository =theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
