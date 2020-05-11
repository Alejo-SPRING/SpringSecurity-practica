package com.springSecurity.backEnd.app.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	public void addViewController(ViewControllerRegistry registry) {
		registry.addViewController("/error403").setViewName("error403");
	}
	
}
