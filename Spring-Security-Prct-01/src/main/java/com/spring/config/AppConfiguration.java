package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfiguration {

	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {

		
		http.authorizeHttpRequests(auth ->{
			
			auth.requestMatchers(HttpMethod.POST, "/customers").permitAll()
			.anyRequest().authenticated();
		})
		.csrf(csrf -> csrf.disable())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		
	
		return http.build();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}

	
//	@Bean
//	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {
//	
//		http.authorizeHttpRequests(a ->{
//			a.requestMatchers(HttpMethod.POST, "/customers").permitAll()
//			.anyRequest()
//			.authenticated();
//		})
//		.csrf(c->c.disable())
//		.formLogin(Customizer.withDefaults())
//		.httpBasic(Customizer.withDefaults());
//		return http.build();
//	}
//	@Bean
//	public PasswordEncoder passWordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
	
}
