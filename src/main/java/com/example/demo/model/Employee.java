package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="employees")
@Table(name="employees")
public class Employee {
    
    @Id
 //   @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private int emp_no;
    @Column()
    private String first_name;
    @Column()
    private String last_name;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date hire_date;
    @Column()
    @Temporal(TemporalType.DATE)
    private Date birth_date;


    

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Employee(int emp_no, String first_name, String last_name, Date hire_date, Date birth_date) {
        this.emp_no = emp_no;
        this.first_name = first_name;
        this.last_name = last_name;
        this.hire_date = hire_date;
        this.birth_date = birth_date;
    }


    public Employee( String first_name, String last_name, Date hire_date, Date birth_date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.hire_date = hire_date;
        this.birth_date = birth_date;
    }


    public Employee(){}

    
}
