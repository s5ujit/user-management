package com.appliedsni.dao;

public interface TokenDao extends BaseJpaDao {
	public Long isTokenValid(String pUserId,String pToken);
	public void deleteToken(String pUserId,String pToken);

}
