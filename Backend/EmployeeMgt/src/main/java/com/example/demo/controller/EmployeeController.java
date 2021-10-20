package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeeModel;
import com.example.demo.service.EmployeeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeModel newEmployee){
		try{
			if(employeeService.addEmployee(newEmployee)) {
			return ResponseEntity.ok(newEmployee);
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		}catch(IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@PostMapping("/remove")
	public ResponseEntity<?> removeEmployee(@RequestParam String empID){
		try {
			if(employeeService.removeEmployee(empID)) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			} else {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			
		}catch(IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/getByID")
	public ResponseEntity<EmployeeModel> getEmployeeByID(@RequestParam String empID){
		try {
			EmployeeModel emp = employeeService.getEmployeeByID(empID);
			return ResponseEntity.ok(emp);
			
		}catch(IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeModel>> getAllEpmloyees(){
		try {
		List<EmployeeModel> list = employeeService.getAllEmployees();
		return ResponseEntity.ok(list);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
