package com.durga.beans;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class OptionAndNonoptionBean {
	@Autowired
	ApplicationArguments appArgs;
	public void showArgs()
	{
		System.out.println("Non option arguments");
		System.out.println("-----------------------");
		List<String> nonoptionlist=appArgs.getNonOptionArgs();
		nonoptionlist.forEach(str->System.out.println(str));
		System.out.println("Option arguments");
		System.out.println("-----------------");
		Set<String> optionarguments=appArgs.getOptionNames();
		optionarguments.forEach(str->{
			System.out.print(str+"=");
			appArgs.getOptionValues(str).forEach(v->System.out.println(v));
		});
	}

}
