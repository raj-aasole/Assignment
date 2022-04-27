package com.yash.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
int pubid;
String publisher_name;
String email;
String address;




public Publisher() {
	super();
}
public int getPubid() {
	return pubid;
}
public void setPubid(int pubid) {
	this.pubid = pubid;
}
public String getPublisher_name() {
	return publisher_name;
}
public void setPublisher_name(String publisher_name) {
	this.publisher_name = publisher_name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}


}
