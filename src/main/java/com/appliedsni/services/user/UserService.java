package com.appliedsni.services.user;


import javax.servlet.http.HttpServletResponse;

import com.appliedsni.entity.User;

public interface UserService {
	public User loginUser(final User pUserLoginRequest,HttpServletResponse response) throws Exception;
	public User createUser(User pUserLoginRequest) throws Exception;
	public void logout(User pUserLoginRequest)throws Exception;
	void isVlaidSession(String pUserId,String pToken) throws Exception;
	void deleteSession(String pUserId,String pToken)throws Exception;

}
