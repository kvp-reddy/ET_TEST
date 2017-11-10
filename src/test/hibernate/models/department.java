package test.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity public class department {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int dep_id;
	private String name;
	public int getId() {
		return dep_id;
	}
	public void setId(int id) {
		this.dep_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
