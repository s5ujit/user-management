package com.appliedsni.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appliedsni.dao.CompanyDao;
import com.appliedsni.entity.Company;
import com.appliedsni.entity.Project;
import com.appliedsni.exception.DaoException;
@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyDao companyDao;

	@Override
	public List<Company> findCompany(String pUser) {
		// TODO Auto-generated method stub
		return companyDao.findCompany(pUser);
		 
	}

	@Override
	public Company findCompanyById(long id) throws DaoException {
		// TODO Auto-generated method stub
		Company company=new Company();
		company.setId(id);
		return companyDao.findbyPK(company);
	}

	@Override
	public Project findProjectById(long id) throws DaoException {
		// TODO Auto-generated method stub
		Project project=new Project();
		project.setId(id);
		return companyDao.findbyPK(project);
	}

	@Override
	public List<Project> findProjectByCompany(long comapnyId) {
		// TODO Auto-generated method stub
		companyDao.findProjectByCompany(comapnyId);
		return null;
	}
	
	

}
