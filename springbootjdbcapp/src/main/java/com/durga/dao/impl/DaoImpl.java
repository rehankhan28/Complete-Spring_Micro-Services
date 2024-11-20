package com.durga.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.durga.dao.ItestDao;

@Repository
public class DaoImpl implements ItestDao {
	@Autowired
	JdbcTemplate jt;

	@Override
	public void insertRecords() {
		jt.update("insert into emp values(1007,'Avinash',30000,10)");
		jt.update("insert into emp values(1008,'krishna',20000,10)");
		
	}

	@Override
	public List selectRecords() {
		
		return jt.queryForList("select * from emp");
	}

}
