package com.yash.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yash.User;
import com.yash.com.UserDAO;

public class UserMain {

	public static void main(String[] args) {
		
		ApplicationContext ac= new ClassPathXmlApplicationContext("applicationcontext.xml");
		
		UserDAO ud=(UserDAO)ac.getBean("udao");
		
		
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println(" \n 1: Insert\n 2: search a user by firstname\n 3: search a user by mobile no\n 4: Exit  ");
			int ch=sc.nextInt();
			sc.nextLine();
			
			switch(ch) {
			
			case 1:
				while(true) {
					System.out.println("Enter First Name");
					String fn=sc.nextLine();
					System.out.println("Enter Last Name");
					String ln=sc.nextLine();
					System.out.println("Enter Address1");
					String add1=sc.nextLine();
					System.out.println("Enter Address2");
					String add2=sc.nextLine();
					System.out.println("Enter DOB");
					String dob=sc.nextLine();
					System.out.println("Enter Email");
					String email=sc.nextLine();
					System.out.println("Enter Password");
					String p=sc.nextLine();
					System.out.println("Enter City");
					String c=sc.nextLine();
					System.out.println("Enter Mobile No");
					String m=sc.nextLine();
					
					User u=new User();
					
					u.setFirstname(fn);
					u.setLastname(ln);
					u.setAdd1(add1);
					u.setAdd2(add2);
					u.setDob(dob);
					u.setEmail(email);
					u.setPassword(p);
					u.setCity(c);
					u.setMobile(m);
					
					ud.inserRecord(u);
					System.out.println("want to do more 1 for yes 0 for no");
					ch=sc.nextInt();
					sc.nextLine();
					if(ch==0)
						 break;
		  		 
					
				}
				
			case 2:
				String f1;
				System.out.println("Enter First name ");
				f1 = sc.nextLine();
				List<User> ur = ud.getEmpByname(f1);
				for (User e : ur) {

					if (f1.equals(e.getFirstname())) {

						System.out.println(e.getUserid()+"-"+e.getFirstname() + "-" + e.getLastname() + "-" + e.getAdd1() + "-"
								+ e.getAdd2() + "-" + e.getDob() + "-" + e.getEmail() + "-" + e.getPassword() + "-"
								+ e.getCity() + "-" + e.getMobile());

					}}
					break;
					
			case 3:
				String f2;
				System.out.println("Enter valid mobile number");
				f2=sc.nextLine();
				List<User> mn=ud.getEmpByMobile(f2);
				for(User m:mn) {
					
					if(f2.equals(m.getMobile())) {
						System.out.println(m.getUserid()+"-"+m.getFirstname() + "-" + m.getLastname() + "-" + m.getAdd1() + "-"
								+ m.getAdd2() + "-" + m.getDob() + "-" + m.getEmail() + "-" + m.getPassword() + "-"
								+ m.getCity() + "-" + m.getMobile());
						
					}

				}
				break;
			default:
			case 4:
				System.out.println("Thank you");
			}		
			}
		}
	}


