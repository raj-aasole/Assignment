package com.yash.com;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

import com.yash.User;

public class UserDAO {
      
	HibernateTransactionManager ht;

	public HibernateTransactionManager getHt() {
		return ht;
	}

	public void setHt(HibernateTransactionManager ht) {
		this.ht = ht;
	}
	
	public User getuserById(int uid) {
		
		SessionFactory sf= ht.getSessionFactory();
		Session objSession = sf.openSession();
		Transaction t = objSession.beginTransaction();
		
		User u = (User) objSession.get(User.class,uid);
		return u;
	}
	
	public void inserRecord(User u) {
		
		SessionFactory sf= ht.getSessionFactory();
		Session objSession = sf.openSession();
		Transaction t = objSession.beginTransaction();
		
		objSession.save(u);
		  
		  t.commit();
		  System.out.println("Record Inserted");
		  objSession.close();
		
	}
	
	
	public List<User> getEmpByname(String f) {
		SessionFactory sf = ht.getSessionFactory();
		Session objSession = sf.openSession();
		Transaction t = objSession.beginTransaction();
		List<User> ulist=new ArrayList<User>();
		
		Criteria ct=objSession.createCriteria(User.class,f);
		ulist=ct.list();
		return ulist;
	}
	 
	public List<User> getEmpByMobile(String f) {
		SessionFactory sf = ht.getSessionFactory();
		Session objSession = sf.openSession();
		Transaction t = objSession.beginTransaction();
		List<User> ulist=new ArrayList<User>();
		
		Criteria ct=objSession.createCriteria(User.class,f);
		ulist=ct.list();
		return ulist;
	}
	
}
