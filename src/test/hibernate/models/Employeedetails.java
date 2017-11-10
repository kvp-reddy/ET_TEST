package test.hibernate.models;

import java.sql.Date;

public class Employeedetails {
	
	private String fname;
	private String lname;
	private designation designation;
	private department department;
	private int salary;
	private address empadd;
	private Date joiningdate;
	private Date dob;
	private city working_city;
	private state working_state;
	private country working_country;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public designation getDesignation() {
		return designation;
	}
	public void setDesignation(designation desg) {
		this.designation = desg;
	}
	public department getDepartment() {
		return department;
	}
	public void setDepartment(department department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public address getEmpadd() {
		return empadd;
	}
	public void setEmpadd(address empadd) {
		this.empadd = empadd;
	}
	public Date getJoiningdate() {
		return joiningdate;
	}
	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public city getWorking_city() {
		return working_city;
	}
	public void setWorking_city(city working_city) {
		this.working_city = working_city;
	}
	public state getWorking_state() {
		return working_state;
	}
	public void setWorking_state(state working_state) {
		this.working_state = working_state;
	}
	public country getWorking_country() {
		return working_country;
	}
	public void setWorking_country(country working_country) {
		this.working_country = working_country;
	}
	
}
