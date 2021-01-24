package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.demo.model.Individual;
import com.example.demo.repository.IndividualsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndividualsService {
    @Autowired
    IndividualsRepository individualRepository;

	public List<Individual> getIndividuals(){
		return individualRepository.findAll();
	}
	
	public List<Individual> getIndividualsByName(String name){
		return individualRepository.findByFirstName(name);
	}

	public Optional<Individual> getIndividualById(Integer id) {
		return individualRepository.findById(id); 
	}
	@Transactional
	public Individual insertIndividual(Individual individual) {
		return individualRepository.save(individual);
	}
	public long countIndividuals(){
		return individualRepository.count();
	}

	public void deleteIndividual(Individual departament){
		individualRepository.delete(departament);
	}

	public void deleteById(Integer id){
		individualRepository.deleteById(id);
	}

}
