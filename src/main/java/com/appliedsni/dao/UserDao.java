package com.appliedsni.dao;

import java.util.List;

import com.appliedsni.entity.AccessRight;
import com.appliedsni.entity.User;
public interface UserDao extends BaseJpaDao{
	public List<User> findUserByEmail(final String pEmail);
	public List<AccessRight> getAccessRight();

}
