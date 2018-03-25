package com.appliedsni.dao;

import java.util.List;
import com.appliedsni.entity.Company;
import com.appliedsni.entity.Project;

public interface CompanyDao extends BaseJpaDao{
	public List<Company> findCompany(String pUser);
	public List<Project> findProjectByCompany( long pComapnyId) ;

}
