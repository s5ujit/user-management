package com.appliedsni.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.appliedsni.entity.Company;
import com.appliedsni.entity.Project;
import com.appliedsni.entity.User;
import com.appliedsni.exception.DaoException;
import com.appliedsni.exception.UserException;
import com.appliedsni.security.jwtsecurity.model.JwtUserDetails;
import com.appliedsni.services.UserService;
import com.appliedsni.utility.ServerUrl;

@RestController
@RequestMapping(ServerUrl.ROOT_URL)
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping(value = ServerUrl.USERS)
	public List<User> test() throws Exception {
		List<User> userList = userService.findUsers();
		return userList;
	}
	
	@GetMapping(value=ServerUrl.USER)
    public User getUser(@PathVariable("id") long id) throws UserException, DaoException {
        User user = userService.findById(id);
        if (user == null) {
            throw new UserException("Usr Not Found"); 
        }
        return null;
    }
	@GetMapping(value = ServerUrl.USER_PROJECTS)
	public List<Project> getProjectList(@PathVariable("id") long pUserId )
	{
		
		List<Project> project = userService.getProjectList( pUserId );
		return project;
	}
	@GetMapping(value = ServerUrl.USER_COMPANYS)
	public List<Company> getCompanyList(@PathVariable("id")long pUserId )
	{
		
		List<Company> company = userService.getCompanyList(pUserId);
		return company;
	}
	@PutMapping(value=ServerUrl.USER)
	public void updateUser(@PathVariable("id") long id,@RequestBody User pUser) throws DaoException, UserException{
		userService.updateUser(id,pUser);
	  
	}
}
