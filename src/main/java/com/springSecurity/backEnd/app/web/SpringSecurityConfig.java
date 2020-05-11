package com.springSecurity.backEnd.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springSecurity.backEnd.app.web.services.UserJpaRegistryService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private LoginSuccessHandler success;
	@Autowired
	private UserJpaRegistryService user;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/js/**").permitAll().anyRequest().authenticated().and()
		.formLogin().loginPage("/login").successHandler(success).permitAll().and()
		.logout().permitAll().and()
		.exceptionHandling().accessDeniedPage("/error403");
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	protected void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(user).passwordEncoder(encoder());
	}
	
}
