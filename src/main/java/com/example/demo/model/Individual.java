package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.GeneratedValue;	
import javax.persistence.GenerationType;

@Entity(name="indvls")
@Table(name="indvls")
public class Individual {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="indvlPK")
    private int id;

    @Column(name="last_name")
    private String lastName;

    @Column(name="first_name")
    private String firstName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="actAGREg")
    private String actAGREg;

    @Column(name="link")
    private String link;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="city")
    private String city;


    

    public int getId() {
        return id;
    }

    public void setId(int emp_no) {
        this.id = emp_no;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public String getMiddle_name() {
        return middleName;
    }

    public void setMiddle_name(String middle_name) {
        this.middleName = middle_name;
    }

    public String getActAGREg() {
        return actAGREg;
    }

    public void setActAGREg(String actAGREg) {
        this.actAGREg = actAGREg;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPostal_code() {
        return postalCode;
    }

    public void setPostal_code(String postal_code) {
        this.postalCode = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Individual(int emp_no, String last_name, String first_name, String middle_name, String actAGREg, String link,
            String postal_code, String city) {
        this.id = emp_no;
        this.lastName = last_name;
        this.firstName = first_name;
        this.middleName = middle_name;
        this.actAGREg = actAGREg;
        this.link = link;
        this.postalCode = postal_code;
        this.city = city;
    }

    public Individual( String last_name, String first_name, String middle_name, String actAGREg, String link,
            String postal_code, String city) {
        this.lastName = last_name;
        this.firstName = first_name;
        this.middleName = middle_name;
        this.actAGREg = actAGREg;
        this.link = link;
        this.postalCode = postal_code;
        this.city = city;
    }

    public Individual() {

    }

}