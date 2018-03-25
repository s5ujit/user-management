package com.appliedsni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.appliedsni.entity.User;
import com.appliedsni.services.user.UserService;
import com.appliedsni.utility.ServerUrl;

@RestController
@RequestMapping(ServerUrl.rootUrl)
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping(value = ServerUrl.createUser)
	public @ResponseBody User createUser(@RequestBody final User pUserLoginRequest) throws Exception {
		User userLoginResponse = userService.createUser(pUserLoginRequest);
		return userLoginResponse;
	}

	@GetMapping(value = ServerUrl.usersList)
	public List<User> test() throws Exception {
		List<User> userList = userService.findUsers();
		return userList;
	}
}
