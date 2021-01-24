package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.service.specifications.DepartmentSpecification;
import javax.transaction.Transactional;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * DepartmentService
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;
	
	public List<Department> getDepartmentsWithEspecification(){
			Department filter = new Department();
			Specification<Department> specification = new DepartmentSpecification(filter);
			return departmentRepository.findAll(specification);
	}

	public List<Department> getDepartments(){
		return departmentRepository.findAll();
	}
	
	public List<Department> getDepartments(String dept_name){
		if(dept_name == null){
			Department filter = new Department(dept_name);
			Specification<Department> specification = new DepartmentSpecification(filter);
			return departmentRepository.findAll(specification);
		}else{
			return departmentRepository.searchByDept_name(dept_name);
		}
		
	}

	public Optional<Department> getdepartmentById(String id) {
		return departmentRepository.findById(id); 
	}
	@Transactional
	public Department insertdepartment(Department department) {
		return departmentRepository.save(department);
	}
	public long countDepartments(){
		return departmentRepository.count();
	}

	public void deleteDepartment(Department departament){
		departmentRepository.delete(departament);
	}

	public void deleteById(String id){
		departmentRepository.deleteById(id);
	}

	// public List<Department> find(String departmentName){
	// 	return departmentRepository.findByname(departmentName);
	// }




}


