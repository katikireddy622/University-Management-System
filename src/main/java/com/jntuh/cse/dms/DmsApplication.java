package com.jntuh.cse.dms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication(exclude = {JpaRepositoriesAutoConfiguration.class})
@EntityScan(basePackages= {"com.jntuh.cse.dms.model"})
@ComponentScan("com.jntuh.cse.dms")
public class DmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmsApplication.class, args);
			
		BCryptPasswordEncoder encoder=null;
		encoder= new BCryptPasswordEncoder();
		
	System.out.println(encoder.encode("a8032121"));
		
		}
}
