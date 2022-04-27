package com.yash.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Auther {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
int auid;
String auther_name;
String email;

public Auther() {
	super();
}

public int getAuid() {
	return auid;
}
public void setAuid(int auid) {
	this.auid = auid;
}
public String getAuther_name() {
	return auther_name;
}
public void setAuther_name(String auther_name) {
	this.auther_name = auther_name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
}
