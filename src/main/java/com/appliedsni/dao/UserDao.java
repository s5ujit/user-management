package com.appliedsni.dao;

import java.util.List;


import com.appliedsni.entity.AccessRight;
import com.appliedsni.entity.Company;
import com.appliedsni.entity.Project;
import com.appliedsni.entity.User;
public interface UserDao extends BaseJpaDao{
	public List<User> findUserByEmail(final String pEmail);
	public List<AccessRight> getAccessRight();
	public List<User> findUserList();
	List<Project> getProjectList(long pUserId);
	public List<Company> getComapnyList(long pUserId);

}
