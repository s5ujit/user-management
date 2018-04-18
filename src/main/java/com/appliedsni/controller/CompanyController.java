package com.appliedsni.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appliedsni.dao.CompanyDao;
import com.appliedsni.entity.Company;
import com.appliedsni.entity.User;
import com.appliedsni.exception.DaoException;
import com.appliedsni.security.jwtsecurity.model.JwtUserDetails;
import com.appliedsni.services.CompanyService;
import com.appliedsni.services.UserService;
import com.appliedsni.utility.ServerUrl;

@RestController
@RequestMapping(ServerUrl.ROOT_URL)
public class CompanyController {
	@Autowired
	CompanyService companyService;
	@Autowired
	UserService userService;
	@Autowired
	CompanyDao companyDao;
	
	@GetMapping(value = ServerUrl.COMPANYS)
	public List<Company> findCompany() {
		return companyService.companyList();

	}

	@GetMapping(value = ServerUrl.COMPANY_BY_ID)
	public Company findCompanyById(@PathVariable long id) throws DaoException {
		Company company=new Company();
		company.setId(id);
		company=companyDao.findbyPK(company);
		return company;
	}
	@PostMapping(value=ServerUrl.COMPANY)
	public Company createCompany(@RequestBody Company pCompany) throws Exception{
		return companyService.createCompany(pCompany);
	}


	

}
