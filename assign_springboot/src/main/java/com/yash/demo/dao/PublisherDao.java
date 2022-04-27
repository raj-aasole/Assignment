package com.yash.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.yash.demo.model.Publisher;


//import com.yash.demo.model.Auther;

@Component
public class PublisherDao {
	
	@Autowired
	JdbcTemplate jdbc;
	
		

	public int addPublishe(Publisher publisher) {
		if(jdbc!= null) {
		int rcount;
		rcount= jdbc.update("insert into publisher (pubid, publisher_name, email, address) values(?,?,?,?)", publisher.getPubid(), publisher.getPublisher_name(),publisher.getEmail(), publisher.getAddress());
		return rcount;
		}
		return 0;
	}

	public List<Publisher> getAllPublisher(){
		return jdbc.query("select * from publisher", new RowMapper <Publisher>() {
			public Publisher mapRow(ResultSet rs, int rowno) throws SQLException{
				Publisher objpub= new Publisher();
				objpub.setPubid(rs.getInt("pubid"));
				objpub.setPublisher_name(rs.getString("publisher_name"));
				objpub.setEmail(rs.getString("email"));
				objpub.setAddress(rs.getString("address"));
				return objpub;
			}
		});
	}
		
	//getting by specific Id
    public Publisher get(int pubid) {
    String sql = "SELECT * FROM PUBLISHER WHERE pubid = ?";
    Object [] args = {pubid};
    Publisher publisher= jdbc.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Publisher.class));
    return publisher;
      }
    
 //Update Method
     public void update(Publisher publisher) {
    	 
    String sql = "UPDATE publisher SET publisher_name=:publisher_name, email=:email, address=:address WHERE pubid=:pubid";
    BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(publisher);
    NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbc);
    template.update(sql, param);    
}
     
//delete method
			public void delete(int pubid) {
			    String sql = "DELETE FROM PUBLISHER WHERE pubid = ?";
			    jdbc.update(sql, pubid);
			}
	
}
