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


import com.yash.demo.model.Booktitle;


@Component
public class bookTitleDao {
	@Autowired
	JdbcTemplate jdbc;
		

	public int addBooktitle(Booktitle bt) {
		if(jdbc!= null) {
		int rcount;
		rcount= jdbc.update("insert into booktitle (btid, title, auid, pubid, price) values(?,?,?,?,?)",
				bt.getBtid(), bt.getTitle(), bt.getAuid(), bt.getPubid(), bt.getPrice());
		
		return rcount;
		}
		return 0;
	}

	public List<Booktitle> getAllbooktitle(){
		return jdbc.query("select * from booktitle", new RowMapper <Booktitle>() {
			public Booktitle mapRow(ResultSet rs, int rowno) throws SQLException{
				Booktitle objb= new Booktitle();
				objb.setBtid(rs.getInt("btid"));
				objb.setTitle(rs.getString("title"));
				objb.setAuid(rs.getInt("auid"));
				objb.setPubid(rs.getInt("pubid"));
				objb.setPrice(rs.getInt("price"));
				return objb;
			}
		});
	}
	
	//getting by specific Id
    public Booktitle get(int btid) {
    String sql = "SELECT * FROM booktitle WHERE btid = ?";
    Object [] args = {btid};
    Booktitle booktitle= jdbc.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Booktitle.class));
    return booktitle;
      }
    
 //Update Method
     public void update(Booktitle booktitle) {
    	 
    String sql = "UPDATE booktitle SET title=:title, auid=:auid, pubid=:pubid, price=:price WHERE btid=:btid";
    BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(booktitle);
    NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbc);
    template.update(sql, param);    
}
     
//delete method
			public void delete(int btid) {
			    String sql = "DELETE FROM booktitle WHERE btid = ?";
			    jdbc.update(sql, btid);
			}
		
}
