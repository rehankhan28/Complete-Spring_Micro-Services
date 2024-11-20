package com.durga.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.durga.beans.OptionAndNonoptionBean;
@Component
public class MyRunner implements CommandLineRunner {
@Autowired
OptionAndNonoptionBean bean;
	@Override
	public void run(String... args) throws Exception {
		bean.showArgs();
		

	}

}
