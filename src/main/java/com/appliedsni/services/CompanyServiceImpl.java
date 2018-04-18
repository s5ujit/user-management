package com.appliedsni.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appliedsni.dao.CompanyDao;
import com.appliedsni.entity.Company;
import com.appliedsni.entity.Project;
import com.appliedsni.exception.DaoException;
import com.appliedsni.request.validator.CompanyRequestValidator;
@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyDao companyDao;
	@Autowired
	CompanyRequestValidator companyRequestValidator;



	@Override
	public Company findCompanyById(long id) throws DaoException {
		// TODO Auto-generated method stub
		Company company=new Company();
		company.setId(id);
		return companyDao.findbyPK(company);
	}


	@Override
	@Transactional
	public Company createCompany(Company pCompany) throws Exception {
		// TODO Auto-generated method stub
		companyRequestValidator.createCompanyValidate(pCompany);
		companyDao.create(pCompany);
		return pCompany;
	}


	@Override
	public List<Company> companyList() {
		// TODO Auto-generated method stub
		return companyDao.companyList();
		 
	}
	
	

}
