package com.jntuh.cse.dms.security;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jntuh.cse.dms.service.MyAppUserDetailsService;


@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource ds;
	
	@Autowired
	MyAppUserDetailsService myAppUserDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(myAppUserDetailsService).passwordEncoder(passwordEncoder());
	}
        @Bean
        public PasswordEncoder passwordEncoder() {
    	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	        return passwordEncoder;
        }
	
	
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
//		authenticationMgr.inMemoryAuthentication()
//			.withUser("journaldev")
//			.password("{noop}jd@123")
//			.authorities("ROLE_USER");
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/faculty/**").access("hasRole('ROLE_FACULTY')")
			.antMatchers("/hod/**").access("hasRole('ROLE_HOD')")
			.antMatchers("/student/**").access("hasRole('ROLE_STUDENT')")
			.antMatchers("/css/**").permitAll()
			.and()
				.formLogin().loginPage("/loginPage")
				.defaultSuccessUrl("/dashboard")
				.failureUrl("/loginPage?error")
				.usernameParameter("username").passwordParameter("password")				
			.and()
				.logout().logoutSuccessUrl("/loginPage?logout").and()
				.exceptionHandling().accessDeniedPage("/403");
	}
	
	
}