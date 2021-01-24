package com.example.demo.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import com.example.demo.model.Individual;
import com.example.demo.service.IndividualsService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndividualsController {
    @Autowired
    private IndividualsService individualsService;

    @GetMapping(value = "/users")
    public List<Individual> getIndividuals(@RequestParam(required=false) String name){

        if(name != null){
            return individualsService.getIndividualsByName(name);
        }else{
            return individualsService.getIndividuals();
        }
    }

    @PostMapping(value="/users")
    public Individual addIndividual(@RequestBody Individual individual){
        return individualsService.insertIndividual(individual);
    }

}
