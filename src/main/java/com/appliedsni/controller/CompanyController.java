package com.appliedsni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appliedsni.entity.Company;
import com.appliedsni.entity.Project;
import com.appliedsni.entity.User;
import com.appliedsni.security.jwtsecurity.model.JwtUserDetails;
import com.appliedsni.services.user.CompanyService;
import com.appliedsni.services.user.UserService;
import com.appliedsni.utility.ServerUrl;

@RestController
@RequestMapping(ServerUrl.rootUrl)
public class CompanyController {
	@Autowired
	CompanyService companyService;
	@Autowired
	UserService userService;
	@GetMapping(value = ServerUrl.companyList)
	public List<Company> findCompany() {
		JwtUserDetails user= (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User aUser=userService.findUserByEmailId(user.getUsername());
		List<Company> company=aUser.getCompany();
		
		return company;

	}

	@GetMapping(value = ServerUrl.companyById)
	public Company findCompanyById(@PathVariable long id) {
		return null;
	}


	@GetMapping(value = ServerUrl.projectById)
	public List<Project> findProjectById(@PathVariable long id) {
		return null;
	}

	@GetMapping(value = ServerUrl.projectByCompany)
	public List<Project> findProjectByCompany(@PathVariable long comapnyId, @PathVariable long projectId) {
		return null;
	}

}
