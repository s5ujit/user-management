package com.appliedsni.services.user;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.appliedsni.entity.Company;
import com.appliedsni.entity.Project;
import com.appliedsni.entity.User;
import com.appliedsni.exception.DaoException;

public interface UserService {
	public User loginUser(final User pUserLoginRequest,HttpServletResponse response) throws Exception;
	public User createUser(User pUserLoginRequest) throws Exception;
	public void logout(User pUserLoginRequest)throws Exception;
	void isVlaidSession(String pUserId,String pToken) throws Exception;
	public void deleteSession(String pUserId,String pToken)throws Exception;
	public List<User> findUsers();
	public User findUserByEmailId(String pEmailId);
	public List<Project> getProjectList(String pEmailId);
	public List<Company> getCompanyList(String pEmailId);
	public void updateUser(User pUser) throws DaoException;

}
