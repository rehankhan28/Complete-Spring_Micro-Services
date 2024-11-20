package com.durga.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.durga.dao.ItestDao;
@Component
@Order(1)
public class MyRunner implements CommandLineRunner {
@Autowired
ItestDao dao;
	@Override
	public void run(String... args) throws Exception {
		dao.insertRecords();
		List list=dao.selectRecords();
		list.forEach(map->System.out.println(map));
		
	}

}
