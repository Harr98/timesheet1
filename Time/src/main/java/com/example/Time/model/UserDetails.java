package com.example.Time.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nickname;
	private String address;
	private String city;
	private String state;
	private String country;
	private long pincode;
	private String qualification;
	private String designation;
	
	@JoinTable(name="userdetails_modulemaster",
	joinColumns = @JoinColumn(name="user_details_id"),
	inverseJoinColumns = @JoinColumn(name="module_master_id"))
	@ManyToMany
	private List<ModuleMaster> moduleMaster;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public List<ModuleMaster> getModuleMaster() {
		return moduleMaster;
	}
	public void setModuleMaster(List<ModuleMaster> moduleMaster) {
		this.moduleMaster = moduleMaster;
	}
	
	
	
}
