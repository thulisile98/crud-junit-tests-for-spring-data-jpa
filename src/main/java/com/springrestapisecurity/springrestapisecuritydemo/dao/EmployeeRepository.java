package com.springrestapisecurity.springrestapisecuritydemo.dao;

import com.springrestapisecurity.springrestapisecuritydemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
