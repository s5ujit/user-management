package com.appliedsni.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.appliedsni.entity.Profile;
import com.appliedsni.entity.User;
import com.appliedsni.services.user.UserService;

@RestController
@RequestMapping("/rest")
public class LoginController {
	@Autowired
	UserService userService;

	@PostMapping(value = "/login")
	public @ResponseBody User login(@RequestBody final User pUserRequest,HttpServletResponse response) throws Exception {
		User user = userService.loginUser(pUserRequest, response);
		
		return user;
	}
	@PostMapping(value = "/createUser")
	public @ResponseBody  User createUser(@RequestBody final User pUserLoginRequest) throws Exception {
		User userLoginResponse = userService.createUser(pUserLoginRequest);
		return userLoginResponse;
	}
	
	@PostMapping(value = "/logout")
	public void logout(@RequestBody final User pUserLoginRequest) throws Exception {
		
		 userService.deleteSession(pUserLoginRequest.getEmailAddress(),"");
	}
	@PostMapping(value = "/test")
	public @ResponseBody User test(@RequestBody final User pUserLoginRequest) throws Exception {
		User user=new User();
		user.setEmailAddress("sdfd");
		user.setLastName("asasafwewf");
		Profile p=new Profile();
		p.setProfileDescription("wefwe");
		//user.setProfile(p);
		//throw new RuntimeException("test");
		return user;
	}
	@PostMapping(value = "/test1")
	public void test1() throws Exception {
		System.out.println("=============hello==========");
	}
}
