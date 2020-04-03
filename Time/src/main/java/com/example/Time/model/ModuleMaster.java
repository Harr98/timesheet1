package com.example.Time.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ModuleMaster {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String modulename;
	private String modulespecification;
	private long projectid;
	@ManyToOne
	private UserManager userManager;
	@ManyToMany(mappedBy = "moduleMaster")
	private List<UserDetails> userDetails;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getModulename() {
		return modulename;
	}
	public void setModulename(String modulename) {
		this.modulename = modulename;
	}
	public String getModulespecification() {
		return modulespecification;
	}
	public void setModulespecification(String modulespecification) {
		this.modulespecification = modulespecification;
	}
	
	public UserManager getUserManager() {
		return userManager;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public long getProjectid() {
		return projectid;
	}
	public void setProjectid(long projectid) {
		this.projectid = projectid;
	}
	
	
	
}
