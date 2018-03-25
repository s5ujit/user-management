package com.appliedsni.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.appliedsni.constants.Role;
import com.appliedsni.entity.PersistenceObject;
import com.appliedsni.entity.Profile;
import com.appliedsni.exception.DaoException;
@Service
public class ProfileDaoImpl extends BaseJpaDaoImpl implements ProfileDao {

	@Override
	public <T> T findChildbyPK(T pObject, long pOid) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profile findByProfileId(String pProfileId) {

		Map<String,Object> map=new HashMap<>();
		map.put("pProfileId", pProfileId);
		final Query aquery =super.createQuery("select profile from Profile profile where profile.role = :pProfileId", map);
		List li=aquery.getResultList();
		return (Profile) aquery.getResultList().get(0);
	
	}



}
