package com.example.demo.service;

import java.util.List;


import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee insertEmployee(Employee employee) {
      //Employee emp = new Employee("name", "lastname", new Date(99, 1, 1), new Date(99, 1, 1) );
		  return employeeRepository.save(employee);
    }
    public Employee updateEmployee(Employee employee) {
		  return employeeRepository.save(employee);
    }
    public Employee deleteEmployee(int id) {
		  return null;
    }
    public List<Employee> getEmployees(){
      return employeeRepository.findAll();
    }

    // public Optional<Employee> getEmployeeById(int id){
    //   return employeeRepository.findById(id);
    // }
    
}