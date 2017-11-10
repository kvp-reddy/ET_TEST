package test.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity public class address {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressid;
	@OneToOne
	@JoinColumn(name="city_id")
	private city cty;
	@OneToOne
	@JoinColumn(name="state_id")
	private state st;
	@OneToOne
	@JoinColumn(name="country_id")
	private country cntry;
	private String doorno;
	private String streetname;
	private int pincode;
	public int getaddressid() {
		return addressid;
	}
	public void setaddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getDoorno() {
		return doorno;
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
	public void setDoorno(String doorno) {
		this.doorno = doorno;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
}
