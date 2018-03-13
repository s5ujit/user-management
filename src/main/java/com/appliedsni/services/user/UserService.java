package com.appliedsni.services.user;

import com.appliedsni.dto.UserLoginRequest;
import com.appliedsni.dto.UserLoginResponse;

public interface UserService {
	public UserLoginResponse loginUser(final UserLoginRequest pUserLoginRequest) throws Exception;
	public UserLoginResponse createUser(UserLoginRequest pUserLoginRequest) throws Exception;

}
