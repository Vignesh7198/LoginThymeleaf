package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@EntityScan("com.example.demo.entity")
public class SpringSecurityMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityMasterApplication.class, args);
	}

	
	@Bean
	public InternalResourceViewResolver view() {
		
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		
		view.setPrefix("/templates/");
		view.setSuffix(".xhtml");

		return view;
	}
}
