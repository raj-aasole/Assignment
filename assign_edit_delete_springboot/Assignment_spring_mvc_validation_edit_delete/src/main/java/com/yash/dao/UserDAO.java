package com.yash.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.yash.controller.User;


public class UserDAO {
@Autowired	
JdbcTemplate objJdbc;

public void setObjJdbc(JdbcTemplate objJdbc) {
}
 public int saveUser(User obju)
 {
	 String sql="insert into user (name,pass,email,address,mobileno) values(?,?,?,?,?)";
	 return objJdbc.update(sql, obju.getName(),obju.getPass(),obju.getEmail(),obju.getAddress(),Long.parseLong(obju.getMobileno()) );

 }
   public List<User> getAllEmp()
   {	   
	  return objJdbc.query("select * from user",new RowMapper <User>() 		{
		  public User mapRow(ResultSet rs,int rowno) throws SQLException
		  {
			  User obju = new User();
			  obju.setUid(rs.getInt("uid"));
			  obju.setName(rs.getString("name"));
			  obju.setEmail(rs.getString("email"));
			  obju.setAddress(rs.getString("address"));
			  obju.setMobileno(""+rs.getLong("mobileno"));
			  return obju;
		  }
	  	}  );
   }
   public List<User> getEmp(String id)
   {	   
	  // System.out.println(id);
	  return objJdbc.query("select * from user where uid="+Integer.parseInt(id),new RowMapper <User>() 		{
		  public User mapRow(ResultSet rs,int rowno) throws SQLException
		  {
			  User obju = new User();
			  obju.setUid(rs.getInt("uid"));
			  obju.setName(rs.getString("name"));
			  obju.setEmail(rs.getString("email"));
			  obju.setAddress(rs.getString("address"));
			  obju.setMobileno(""+rs.getLong("mobileno"));
			  
//			  System.out.println(obju.getUid()+"   "+obju.getName());
			  
			  
			  return obju;
		  }
	  	}  );
   }
   public int updateuser(User objE)
   {
	  
	  String query = "update user set name='"+objE.getName()+"',address='"+objE.getEmail()+"',address='"+objE.getAddress()+"', mobileno='"+Long.parseLong(objE.getMobileno())+"' Where uid="+objE.getUid();
	  return objJdbc.update(query);
	 
   }
   public int deleteuser(String id)
	{
		String query ="delete from user where uid="+Integer.parseInt(id);
		System.out.println(query);
		return objJdbc.update(query);
	}
}
