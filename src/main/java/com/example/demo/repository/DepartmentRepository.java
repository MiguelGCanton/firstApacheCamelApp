package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, String>, JpaSpecificationExecutor<Department> {
    @Query("select d from Department d where LOWER(d.deptname) = LOWER( :departmentName )")
    public List<Department> findByname(@Param("departmentName") String departmentName);

    @Query("SELECT m FROM Department m WHERE m.deptname LIKE :dept_name%")
    List<Department> searchByDept_name(@Param("dept_name") String dept_name);
}