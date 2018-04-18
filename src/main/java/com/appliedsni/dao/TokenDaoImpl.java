package com.appliedsni.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.appliedsni.entity.UserSession;
import com.appliedsni.exception.DaoException;

@Repository
public class TokenDaoImpl extends BaseJpaDaoImpl implements TokenDao {

	@Override
	public Long isTokenValid(String pUserId, String pToken) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder(pToken);
		Map<String, Object> map = new HashMap<>();
		map.put("pToken", pToken);
		map.put("pUserId", pUserId);
		final Query aquery = super.createQuery(
				"select  count(*) from UserSession userSession where userSession.userId = :pUserId"
				+ " and userSession.token = :pToken",
				map);
		Long count = (Long)(aquery.getSingleResult());
		return count;

	}

	@Override
	public <T> T findChildbyPK(T pObject, long pOid) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void deleteToken(String pUserId, String pToken) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("pToken", pToken);
		map.put("pUserId", pUserId);
		final Query aquery = super.createQuery(
				"delete from UserSession userSession where userSession.userId = :pUserId"
				+ " and userSession.token =:pToken ",
				map);
		aquery.executeUpdate();

	}

}
