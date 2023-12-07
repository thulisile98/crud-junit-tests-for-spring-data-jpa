package com.springrestapisecurity.springrestapisecuritydemo.service;

import com.springrestapisecurity.springrestapisecuritydemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
