package com.appliedsni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appliedsni.dao.CompanyDao;
import com.appliedsni.entity.Company;
import com.appliedsni.entity.Project;
import com.appliedsni.entity.User;
import com.appliedsni.exception.DaoException;
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
	@Autowired
	CompanyDao companyDao;
	@GetMapping(value = ServerUrl.companyList)
	public List<Company> findCompany() {
		JwtUserDetails user= (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User aUser=userService.findUserByEmailId(user.getUsername());
		List<Company> company=aUser.getCompany();
		return company;

	}

	@GetMapping(value = ServerUrl.companyById)
	public Company findCompanyById(@PathVariable long id) throws DaoException {
		Company company=new Company();
		company.setId(id);
		company=companyDao.findbyPK(company);
		return company;
	}


	

}
