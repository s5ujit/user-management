package com.appliedsni.main;





import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.appliedsni.security.jwtsecurity.security.AccessRightFilter;

@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan
@ComponentScan("com.appliedsni")
@EntityScan(basePackages = {"com.appliedsni.entity"}) 
public class JwtSecurityApplication {


	public static void main(String[] args) {
		SpringApplication.run(JwtSecurityApplication.class, args);
	}
	
}
