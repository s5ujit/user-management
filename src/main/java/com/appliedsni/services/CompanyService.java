package com.appliedsni.services;

import java.util.List;


import com.appliedsni.entity.Company;
import com.appliedsni.entity.Project;
import com.appliedsni.exception.DaoException;

public interface CompanyService {
	public Company findCompanyById( long id) throws DaoException;
	public Company createCompany(Company pCompany) throws Exception;
	public List<Company> companyList();

}
