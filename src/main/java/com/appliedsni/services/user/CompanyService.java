package com.appliedsni.services.user;

import java.util.List;


import com.appliedsni.entity.Company;
import com.appliedsni.entity.Project;
import com.appliedsni.exception.DaoException;

public interface CompanyService {
	List<Company> findCompany(String pUsers);
	public Company findCompanyById( long id) throws DaoException;
	public Project findProjectById( long id) throws DaoException; 
	public List<Project> findProjectByCompany( long comapnyId);

}
