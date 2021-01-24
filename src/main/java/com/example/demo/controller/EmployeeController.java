package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


@RestController()
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees/count")
    public int countStudents(@RequestParam(name = "name") String name) {
        System.out.println(name);
        return 3;
    }

    @GetMapping(value = "/employees")
    public List<Employee> getStudents() {
        List<Employee> list = employeeService.getEmployees();
        System.out.println("akjsdhaksdhskj");
        return list;
    }


    @PostMapping(value = "/employees")
    public Employee addStudent() {
        
        return employeeService.insertEmployee(null);
    }
    
    
    @GetMapping(value="/employees/count/{id}")
    public int getStudentById(@RequestAttribute(name="id") int id) {
        System.out.println(id);
        return 3;
    }

    // @PostMapping(value="/employees")
    // public ResponseEntity<Employee> postMethodName(@RequestBody Employee entity) {
    //     Employee employee = employeeService.insertEmployee(entity);
    //     return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    // }
    

}