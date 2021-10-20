package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class EmployeeModel {

	@Id
	@Column(name = "emp_id", nullable = false)
	private String empID;

	@Column(name = "emp_name", nullable = false)
	private String empName;
	
	@Column(name = "emp_contact", nullable = false)
	private String empContact;
	
	@Column(name = "emp_email", nullable = false)
	private String empEmail;
	
	public EmployeeModel() {
		super();
	}
	
	
	/**
	 * @param empID
	 * @param empName
	 * @param empContact
	 * @param empEmail
	 */
	public EmployeeModel(String empID, String empName, String empContact, String empEmail) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empContact = empContact;
		this.empEmail = empEmail;
	}


	public String getEmpID() {
		return empID;
	}
	public String getEmpName() {
		return empName;
	}
	public String getEmpContact() {
		return empContact;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	
	
}
