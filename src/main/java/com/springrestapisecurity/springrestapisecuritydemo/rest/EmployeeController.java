package com.springrestapisecurity.springrestapisecuritydemo.rest;

import com.springrestapisecurity.springrestapisecuritydemo.entity.Employee;
import com.springrestapisecurity.springrestapisecuritydemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

      @Autowired
     public  EmployeeController(EmployeeService theEmployeeService)
      {
         employeeService=theEmployeeService;
      }

      @GetMapping("/all")
      public  List<Employee> findAll(){
          return  employeeService.findAll();
      }




}
