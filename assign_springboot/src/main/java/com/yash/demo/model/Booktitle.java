package com.yash.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booktitle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
int btid;
String title;
int auid;
int pubid;
int price;



public Booktitle() {
	super();
}


public int getBtid() {
	return btid;
}
public void setBtid(int btid) {
	this.btid = btid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getAuid() {
	return auid;
}
public void setAuid(int auid) {
	this.auid = auid;
}
public int getPubid() {
	return pubid;
}
public void setPubid(int pubid) {
	this.pubid = pubid;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}



}
