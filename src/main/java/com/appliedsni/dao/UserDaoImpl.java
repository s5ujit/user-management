package com.appliedsni.dao;


import java.util.List;
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
			final Query aquery = super.getEntityManager()
					.createNamedQuery("User.findUserInfoByUserId")
					.setParameter("emailAddress", pEmail);
			return aquery.getResultList();
		}

}
