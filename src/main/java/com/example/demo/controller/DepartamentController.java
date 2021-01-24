package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// import javax.persistence.EntityManager;
// import javax.persistence.EntityManagerFactory;
// import javax.persistence.Persistence;
// import javax.persistence.PersistenceContext;

import com.example.demo.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.*;

@RestController()
public class DepartamentController {
    
    @Autowired
    private DepartmentService departmentService;

    // @PersistenceContext
    // EntityManager entityManager; 
    // private static final EntityManagerFactory emf; 
    // static{
    //     emf = Persistence.createEntityManagerFactory("com.example.demo.model.Department_catalog");;
    // }
    @GetMapping(value="/departments")
    public List<Department> getAllDepartaments(@RequestParam(required=false) String departmentName) {   
        if(departmentName != null){
            return departmentService.getDepartments(departmentName);
        } else {
            return departmentService.getDepartments();
        }
        
    }

    @GetMapping(value="/count")
    public long countDepartaments(){
        return departmentService.countDepartments();
    }

  /*  @GetMapping(value="/test")
    public Department getDepartmentWithName(@RequestParam String departmentName){
        return departmentService.find(departmentName).get(0);
    }*/

    // public static EntityManager getEntityManager() {
    //     return emf.createEntityManager();
    // }

}