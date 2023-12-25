package com.springrestapisecurity.springrestapisecuritydemo.rest;

import com.springrestapisecurity.springrestapisecuritydemo.entity.Employee;
import com.springrestapisecurity.springrestapisecuritydemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

      @GetMapping("/employees")
      public  List<Employee> findAll(){
          return  employeeService.findAll();
      }

      @GetMapping("/employee/{employeeId}")
      public  Employee getEmployee(@PathVariable int employeeId){

          Employee theEmployee  = employeeService.findById(employeeId);

          if (theEmployee == null){
              throw  new RuntimeException("employee with that id does not exist");
          }else {
              return theEmployee;
          }
      }


    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee theEmployee){
          return  employeeService.save(theEmployee);
    }

    @DeleteMapping("/employee/{employeeId}")
    public  void deleteEmployee(@PathVariable int employeeId){
          employeeService.deleteById(employeeId);
    }

}
