package com.kenInternational;

import com.kenInternational.project_Config.Project_Configuration;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kenInternational.mapper","com.kenInternational.Entity","com.kenInternational.controller","com.kenInternational.Service","com.kenInternational.Repository","com.kenInternational.project_Config"})
public class SpringBootRestApplication extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired
	private ApplicationContext appContext;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception
	{
		var context = new AnnotationConfigApplicationContext(Project_Configuration.class);

		ModelMapper veh = context.getBean("GetMapper",ModelMapper.class);
		System.out.println("Vehicle name from Spring Context is: " + veh.toString());
	}
}
