package com.appliedsni.dao;

import java.util.List;

import com.appliedsni.entity.Company;

public interface CompanyDao extends BaseJpaDao{
	
	public List<Company> companyList();
}
