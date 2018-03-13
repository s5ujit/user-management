package com.appliedsni.security.jwtsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.appliedsni.dao.UserDao;
import com.appliedsni.dto.UserLoginRequest;
import com.appliedsni.dto.UserLoginResponse;
import com.appliedsni.security.jwtsecurity.model.JwtUser;
import com.appliedsni.security.jwtsecurity.security.JwtGenerator;
import com.appliedsni.services.user.UserService;

@RestController
@RequestMapping("/rest")
public class LoginController {
	@Autowired
	UserService userService;

	@PostMapping(value = "/login")
	@ResponseBody
	public UserLoginResponse login(@RequestBody final UserLoginRequest pUserLoginRequest) throws Exception {
		UserLoginResponse userLoginResponse = userService.loginUser(pUserLoginRequest);
		return userLoginResponse;
	}
	@PostMapping(value = "/createUser")
	@ResponseBody
	public UserLoginResponse createUser(@RequestBody final UserLoginRequest pUserLoginRequest) throws Exception {
		UserLoginResponse userLoginResponse = userService.createUser(pUserLoginRequest);
		return userLoginResponse;
	}
}
