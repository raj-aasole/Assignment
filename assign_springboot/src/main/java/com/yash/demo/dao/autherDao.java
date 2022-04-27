package com.yash.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.yash.demo.model.Auther;

@Component
public class autherDao {

	@Autowired
JdbcTemplate jdbc;
	


public int addAuther(Auther auther) {
	if(jdbc!= null) {
	int rcount;
	rcount= jdbc.update("insert into auther (auid, auther_name, email) values(?,?,?)", auther.getAuid(), auther.getAuther_name(),auther.getEmail());
	return rcount;
	}
	return 0;
}

public List<Auther> getAllAuther(){
	return jdbc.query("select * from auther", new RowMapper <Auther>() {
		public Auther mapRow(ResultSet rs, int rowno) throws SQLException{
			Auther objau= new Auther();
			objau.setAuid(rs.getInt("auid"));
			objau.setAuther_name(rs.getString("auther_name"));
			objau.setEmail(rs.getString("email"));
			return objau;
		}
	});
}
	//getting by specific Id
    public Auther get(int auid) {
    String sql = "SELECT * FROM AUTHER WHERE auid = ?";
    Object [] args = {auid};
    Auther auther= jdbc.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Auther.class));
    return auther;
      }
    
 //Update Method
     public void update(Auther auther) {
    	 
    String sql = "UPDATE auther SET auther_name=:auther_name, email=:email WHERE auid=:auid";
    BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(auther);
    NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbc);
    template.update(sql, param);    
}
     
//delete method
			public void delete(int auid) {
			    String sql = "DELETE FROM AUTHER WHERE auid = ?";
			    jdbc.update(sql, auid);
			}
}
