package com.yash.controller;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.*;
import org.springframework.lang.NonNull;
public class User {
		
 int uid;
 // java script or jquery or angular way /^[a-zA-Z0-9]{2,15}$/
 @NonNull
 @Pattern(regexp="^[a-zA-Z0-9 ]{2,15}$",message="name can only contain alphabets and digits and minimum length is 2")
 String name;
 
 /* @Size(min=2,message="name can not be less than 2 char in length")*/
 @Size(min=7, max = 14, message="password should be between 7 to 14 in length")
 String pass;
 
 @NotEmpty
 @Email(message = "please enter valid email")
 String email;
 
 @NotEmpty(message="please enter address for communication")
 String address;
  
 @Pattern(regexp="^[6-9][0-9]{9}$",message="please start no with 6 ,7, 8 or 9 exact digit 10")
 String mobileno;
 
 public User()
 {	 
 }
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
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
public String getMobileno() {
	return mobileno;
}
public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}
 
}
