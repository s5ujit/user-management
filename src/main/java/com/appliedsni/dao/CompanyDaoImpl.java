package com.appliedsni.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.appliedsni.entity.Company;
import com.appliedsni.entity.Profile;
import com.appliedsni.entity.Project;
import com.appliedsni.exception.DaoException;
@Service
public class CompanyDaoImpl extends BaseJpaDaoImpl implements CompanyDao{

	@Override
	public <T> T findChildbyPK(T pObject, long pOid) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> findCompany(String pUser) {

		Map<String,Object> map=new HashMap<>();
		map.put("pUser", pUser);
		final Query aquery =super.createQuery("select company from Company company where company.user.emailAddress =: pUser", map);
		List<Company> li=aquery.getResultList();
		return li;
	
	}

	public List<Project> findProjectByCompany(long pComapnyId) {


		Map<String,Object> map=new HashMap<>();
		map.put("pComapnyId", pComapnyId);
		final Query aquery =super.createQuery("select project from Project project where project.role = :pComapnyId", map);
		List<Project> li=aquery.getResultList();
		return li;
	
	
	}

	

}
