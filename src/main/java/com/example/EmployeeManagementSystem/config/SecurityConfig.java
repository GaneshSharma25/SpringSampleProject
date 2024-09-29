package com.example.EmployeeManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		    .authorizeHttpRequests((authz) -> authz
		    		.anyRequest().authenticated() // All requests require authentication
		  )
		    .httpBasic() //enable basic authentication
		    .and()
		    .sessionManagement((session) -> session
		    		.maximumSessions(1)
		    		.expiredUrl("/session-expired")
		    );
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("password")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
}
