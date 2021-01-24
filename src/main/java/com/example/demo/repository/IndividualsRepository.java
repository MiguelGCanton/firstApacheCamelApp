package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Individual;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
  * IndividualsRepository
  */
@Repository
 public interface IndividualsRepository extends JpaRepository<Individual, Integer>{
    
  
  @Query(value= "SELECT i FROM indvls i  WHERE i.firstName = ?1 or i.lastName = ?1 or i.middleName =  ?1")
  public List<Individual> findByFirstName( String name);

  //public List<Individual> findByFirstName(String name);
 
  public Optional<Individual> findById(Integer id);
 
  @Override
  public void deleteById(Integer id);

     
 }