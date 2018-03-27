package com.appliedsni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.appliedsni.entity.Company;
import com.appliedsni.entity.Project;
import com.appliedsni.entity.User;
import com.appliedsni.exception.DaoException;
import com.appliedsni.security.jwtsecurity.model.JwtUserDetails;
import com.appliedsni.services.user.UserService;
import com.appliedsni.utility.ServerUrl;

@RestController
@RequestMapping(ServerUrl.rootUrl)
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping(value = ServerUrl.usersList)
	public List<User> test() throws Exception {
		List<User> userList = userService.findUsers();
		return userList;
	}
	@GetMapping(value = ServerUrl.projectList)
	public List<Project> getProjectList()
	{
		JwtUserDetails user = (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Project> project = userService.getProjectList(user.getUserName());
		return project;
	}
	@GetMapping(value = ServerUrl.userCompanyList)
	public List<Company> getCompanyList()
	{
		JwtUserDetails user = (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Company> company = userService.getCompanyList(user.getUserName());
		return company;
	}
	public void updateUser(User pUser) throws DaoException{
		userService.updateUser(pUser);
	  
	}
}
