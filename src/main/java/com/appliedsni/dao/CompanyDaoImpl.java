package com.appliedsni.dao;




import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.appliedsni.entity.Company;
import com.appliedsni.exception.DaoException;
@Repository
public class CompanyDaoImpl extends BaseJpaDaoImpl implements CompanyDao{

	@Override
	public <T> T findChildbyPK(T pObject, long pOid) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> companyList() {
		// TODO Auto-generated method stub
		final Query aquery =super.createQuery("select company from Company company",null);
		return aquery.getResultList();
	}

	

	

	

}
