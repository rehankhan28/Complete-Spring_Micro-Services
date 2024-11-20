package com.durga.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.durga.beans.HelloBean;
@Order(1)
@Component
public class MyRunner implements CommandLineRunner {
@Autowired
HelloBean bean;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Say Hi..!!");
		bean.sayHello();
		
	}

}
