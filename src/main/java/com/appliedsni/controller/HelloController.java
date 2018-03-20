package com.appliedsni.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.appliedsni.entity.Profile;
import com.appliedsni.entity.User;

@RestController
@RequestMapping("/rest/secure")
public class HelloController {

    @GetMapping(value="/hello/{id}")
    public   User hello() {
    	User user=new User();
		user.setEmailAddress("sdfd");
		user.setLastName("asasafwewf");
		Profile p=new Profile();
		p.setProfileDescription("wefwe");
		user.setProfile(p);
		return user;
    }
}
