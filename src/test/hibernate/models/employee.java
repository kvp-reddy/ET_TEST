package test.hibernate.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class employee {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empid;
	
	private String first_name;
	private String last_name;
	
	@OneToOne
	@JoinColumn(name="department_id")
	private department dept;
	
	
	private Date joined_date;
	
	@OneToOne
	@JoinColumn(name="working_city_id")
	private city cty;
	
	@OneToOne
	@JoinColumn(name="working_state_id")
	private state st;
	
	@OneToOne
	@JoinColumn(name="working_country_id")
	private country cntry;
	//private int perm_address_id;
	
	@OneToOne
	@JoinColumn(name="Perm_address_id")
	private address empadd;
	
	@OneToOne
	@JoinColumn(name="designation_id")
	private designation desgn;
	
	private int salary;
	private Date dob;
	
	public int getId() {
		return empid;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public Date getJoined_date() {
		return joined_date;
	}
	public void setJoined_date(Date joined_date) {
		this.joined_date = joined_date;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public address getEmpadd() {
		return empadd;
	}
	public void setEmpadd(address empadd) {
		this.empadd = empadd;
	}
	public department getDept() {
		return dept;
	}
	public void setDept(department dept) {
		this.dept = dept;
	}
	public city getCty() {
		return cty;
	}
	public void setCty(city cty) {
		this.cty = cty;
	}
	public state getSt() {
		return st;
	}
	public void setSt(state st) {
		this.st = st;
	}
	public country getCntry() {
		return cntry;
	}
	public void setCntry(country cntry) {
		this.cntry = cntry;
	}
	public designation getDesgn() {
		return desgn;
	}
	public void setDesgn(designation desgn) {
		this.desgn = desgn;
	}
}
