package com.example.Time.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ProjectManager {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String  projecname;
	private String startdate;
	private String completiondate;
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long clientid;
	private String taskspecification;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProjecname() {
		return projecname;
	}
	public void setProjecname(String projecname) {
		this.projecname = projecname;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getCompletiondate() {
		return completiondate;
	}
	public void setCompletiondate(String completiondate) {
		this.completiondate = completiondate;
	}
	public long getClientid() {
		return clientid;
	}
	public void setClientid(long clientid) {
		this.clientid = clientid;
	}
	public String getTaskspecification() {
		return taskspecification;
	}
	public void setTaskspecification(String taskspecification) {
		this.taskspecification = taskspecification;
	}
	
	
	
}
