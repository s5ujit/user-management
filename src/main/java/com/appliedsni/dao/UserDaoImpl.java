package com.appliedsni.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.appliedsni.dao.BaseJpaDaoImpl;
import com.appliedsni.entity.User;
import com.appliedsni.exception.DaoException;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
@Service
public class UserDaoImpl extends BaseJpaDaoImpl implements UserDao{

		@Override
		public <T> T findChildbyPK(T pObject, long pOid) throws DaoException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<User> findUserByEmail(final String pEmail) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<>();
			map.put("emailAddress", pEmail);
			final Query aquery =super.createQuery("select user from User user where user.emailAddress = :emailAddress", map);
			return aquery.getResultList();
		}

}
