package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeDataRepository;

@Service
public class EmployeeService {
	
	private EmployeeDataRepository employeeDataRepository;
	
	@Autowired
	public EmployeeService(EmployeeDataRepository employeeDataRepository) {
		this.employeeDataRepository = employeeDataRepository;
	}
	
	@Transactional
	public boolean addEmployee(EmployeeModel employee) {
		/*
		 * Check if Emp ID already not present, then add emp and return true
		 * else return false
		 * 
		 */
		if(! (employeeDataRepository.findById(employee.getEmpID()).isPresent()) ) {
			employeeDataRepository.save(employee);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Transactional
	public boolean removeEmployee(String empID) {
		/*
		 * Find by Emp ID -> not present, then return false
		 * else delete and return true
		 * 
		 * Catch exceptions -> return false
		 * 
		 */
		
		try {
			if (!employeeDataRepository.findById(empID).isPresent())
				return false;
			else {
				employeeDataRepository.deleteById(empID);
				return true;
			}
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	@Transactional
	public EmployeeModel getEmployeeByID(String empID) {
		// Returns null if id is not present
		
		try {
			return employeeDataRepository.findById(empID).get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}
	
	@Transactional
	public List<EmployeeModel> getAllEmployees(){
		return employeeDataRepository.findAll();
	}
	
	
}
