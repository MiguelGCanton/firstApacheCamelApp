package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department {
    
    @Id()
    @Column
    private String dept_no;
    @Column
    private String deptname;


    public Department(){

    }

    public Department(String deptname){
        this.deptname = deptname;
    }

    public Department(int id, String deptname){
        
    }

    public String getDept() {
        return dept_no;
    }

    public void setDept(String dept) {
        this.dept_no = dept;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    

}