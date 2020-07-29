package dao;

import java.sql.Date;

public class Employee {
	private String employeeId,employeeName,employeeEmail, employeeCity,employeePincode,employeeHighestDegree,employeePortalPassword;
	private int experience,isTeacher;
	private Date date;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeCity() {
		return employeeCity;
	}
	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}
	public String getEmployeePincode() {
		return employeePincode;
	}
	public void setEmployeePincode(String employeePincode) {
		this.employeePincode = employeePincode;
	}
	public String getEmployeeHighestDegree() {
		return employeeHighestDegree;
	}
	public void setEmployeeHighestDegree(String employeeHighestDegree) {
		this.employeeHighestDegree = employeeHighestDegree;
	}
	public String getEmployeePortalPassword() {
		return employeePortalPassword;
	}
	public void setEmployeePortalPassword(String employeePortalPassword) {
		this.employeePortalPassword = employeePortalPassword;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getIsTeacher() {
		return isTeacher;
	}
	public void setIsTeacher(int isTeacher) {
		this.isTeacher = isTeacher;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
