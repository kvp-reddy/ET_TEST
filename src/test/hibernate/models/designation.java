package test.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity public class designation {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int desgn_id;
	private String designation_name;
	public int getId() {
		return desgn_id;
	}
	public void setId(int id) {
		this.desgn_id = id;
	}
	public String getDesignation_name() {
		return designation_name;
	}
	public void setDesignation_name(String designation_name) {
		this.designation_name = designation_name;
	}
	
}
