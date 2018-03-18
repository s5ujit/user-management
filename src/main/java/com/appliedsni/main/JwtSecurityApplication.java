package com.appliedsni.main;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;

import com.appliedsni.dao.UserDao;
import com.appliedsni.entity.User;
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.appliedsni")
@EntityScan(basePackages = {"com.appliedsni.entity"}) 
public class JwtSecurityApplication {


	public static void main(String[] args) {
		SpringApplication.run(JwtSecurityApplication.class, args);
	}
}
