package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmployeeModel;

@Repository
public interface EmployeeDataRepository extends JpaRepository<EmployeeModel, String> {

}
