package com.appliedsni.dao;


import java.util.HashMap;

import java.util.List;
import java.util.Map;

import com.appliedsni.dao.BaseJpaDaoImpl;
import com.appliedsni.entity.AccessRight;
import com.appliedsni.entity.Company;
import com.appliedsni.entity.Project;
import com.appliedsni.entity.User;
import com.appliedsni.exception.DaoException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Repository
public class UserDaoImpl extends BaseJpaDaoImpl implements UserDao{

		@Override
		public <T> T findChildbyPK(T pObject, long pOid) throws DaoException {
			// TODO Auto-generated method stub
			return null;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<User> findUserByEmail(final String pEmail) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<>();
			map.put("pEmail", pEmail);
			final Query aquery =super.createQuery("select user from User user where user.emailAddress = :pEmail", map);
			return aquery.getResultList();
		}
		@SuppressWarnings("unchecked")
		@Override
		public List<AccessRight> getAccessRight() {
			// TODO Auto-generated method stub
			final Query aquery =super.createQuery("select accessRight from AccessRight accessRight",null);
			return aquery.getResultList();
		}
		@SuppressWarnings("unchecked")
		@Override
		public List<User> findUserList() {
			// TODO Auto-generated method stub
			final Query aquery =super.createQuery("select user from User user",null);
			return aquery.getResultList();
		}

		@Override
		public List<Project> getProjectList(long pUserId) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<>();
			map.put("pUserId", pUserId);
			final Query aquery =super.createQuery("select user.project from User user where user.id = :pUserId", map);
			return aquery.getResultList();
		}
		public List<Company> getComapnyList(long pUserId) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<>();
			map.put("pUserId", pUserId);
			final Query aquery =super.createQuery("select user.company from User user where user.id = :pUserId", map);
			return aquery.getResultList();
		}

		

}
