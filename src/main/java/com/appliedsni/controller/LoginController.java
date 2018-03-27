package com.appliedsni.controller;



import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.appliedsni.entity.User;
import com.appliedsni.services.user.UserService;
import com.appliedsni.utility.ServerUrl;

@RestController
@RequestMapping("/rest")
public class LoginController {
	@Autowired
	UserService userService;

	@PostMapping(value = ServerUrl.login)
	public @ResponseBody User login(@RequestBody final User pUserRequest,HttpServletResponse response) throws Exception {
	
		System.out.println("test  1");
		User user = userService.loginUser(pUserRequest, response);
		
		return user;
	}
	
	@PostMapping(value = ServerUrl.logout)
	public void logout(@RequestBody final User pUserLoginRequest) throws Exception {
		
		 userService.deleteSession(pUserLoginRequest.getEmailAddress(),"");
	}
	@PostMapping(value = ServerUrl.createUser)
	public @ResponseBody User createUser(@RequestBody final User pUserLoginRequest) throws Exception {
		User userLoginResponse = userService.createUser(pUserLoginRequest);
		return userLoginResponse;
	}
	
}
