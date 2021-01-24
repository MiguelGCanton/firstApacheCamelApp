package com.example.demo.configuration.routes;

import java.util.List;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.model.Individual;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRoutes extends RouteBuilder{

    @Autowired
    DepartmentService employeeService;

    @Autowired
    CamelContext apacheCamel;

    @Override
    public void configure() throws Exception {
        rest("/api/")
        .get("/recomendations/friends")
        .to("direct:getProfileInfo");

        rest("/api/")
        .get("/profiles?name={name}")
        .consumes("application/json")
        .produces("application/json")
        .param().name("name").dataType("string").type(RestParamType.query).required(false).endParam()
        .to("direct:getProfilesFromDatabase");

        // rest("/api/")
        // .post("/profiles")
        // .consumes("application/json")
        // .produces("application/json")
        // .to("direct:getProfilesFromDatabase");

        from("direct:getProfileInfo")
        .to("https://randomuser.me/api?bridgeEndpoint=true");

        from("direct:getProfilesFromDatabase")
        .log("his name is ${header.name}")
        .to("http://localhost:8081/users?${header.name}&bridgeEndpoint=true");

        from("direct:addProfilesFromDatabase")
        .setHeader(Exchange.HTTP_METHOD, constant("POST"))
        .convertBodyTo(Individual.class)
        .to("http://localhost:8081/users?bridgeEndpoint=true");

        

   


    }
    
}
