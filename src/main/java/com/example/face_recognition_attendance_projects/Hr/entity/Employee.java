package com.example.face_recognition_attendance_projects.Hr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	@NotNull
	private String employeeName;
	
	@Email
	private String email;
	
	private String gender;
	
	private String dob;
	
	private String joiningDate;
	
	private String mobileNumber;
	
	private String aadharNumber;
	
	private String panNumber;
	
	private String bankAccountNumber;
	
	private String department;
	
	private String designation;
	
	private String previousCompany;
	
	private String pfNumber;
	
	private Double salary;
	
	@Size(max = 1000,min = 10)
	private String currentAddress;
	
	@Size(max = 1000,min = 10)
	private String permanentAddress;
	
	private boolean active=true ;
	
	

	public Employee() {}

	public Employee(Long employeeId, @NotNull String employeeName, @Email String email, String gender, String dob,
			String joiningDate, String mobileNumber, String aadharNumber, String panNumber, String bankAccountNumber,
			String department, String designation, String previousCompany, String pfNumber, Double salary,
			@Size(max = 1000, min = 10) String currentAddress, @Size(max = 1000, min = 10) String permanentAddress,
			boolean active) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.joiningDate = joiningDate;
		this.mobileNumber = mobileNumber;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
		this.bankAccountNumber = bankAccountNumber;
		this.department = department;
		this.designation = designation;
		this.previousCompany = previousCompany;
		this.pfNumber = pfNumber;
		this.salary = salary;
		this.currentAddress = currentAddress;
		this.permanentAddress = permanentAddress;
		this.active = active;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPreviousCompany() {
		return previousCompany;
	}

	public void setPreviousCompany(String previousCompany) {
		this.previousCompany = previousCompany;
	}

	public String getPfNumber() {
		return pfNumber;
	}

	public void setPfNumber(String pfNumber) {
		this.pfNumber = pfNumber;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email
				+ ", gender=" + gender + ", dob=" + dob + ", joiningDate=" + joiningDate + ", mobileNumber="
				+ mobileNumber + ", aadharNumber=" + aadharNumber + ", panNumber=" + panNumber + ", bankAccountNumber="
				+ bankAccountNumber + ", department=" + department + ", designation=" + designation
				+ ", previousCompany=" + previousCompany + ", pfNumber=" + pfNumber + ", salary=" + salary
				+ ", currentAddress=" + currentAddress + ", permanentAddress=" + permanentAddress + ", active=" + active
				+ "]";
	}
	
	
	
}
