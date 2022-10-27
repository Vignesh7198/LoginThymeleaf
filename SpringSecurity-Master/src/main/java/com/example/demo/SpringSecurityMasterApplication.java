package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class SpringSecurityMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityMasterApplication.class, args);
	}

	
	@Bean
	public InternalResourceViewResolver view() {
		
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		
		view.setPrefix("/WEB-INF/view/");
		view.setSuffix(".html");

		return view;
	}
}
