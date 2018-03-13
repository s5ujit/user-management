package com.appliedsni.services.user;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.appliedsni.assembler.UserAssembler;
import com.appliedsni.dao.UserDao;
import com.appliedsni.dto.UserDto;
import com.appliedsni.dto.UserLoginRequest;
import com.appliedsni.dto.UserLoginResponse;
import com.appliedsni.entity.User;
import com.appliedsni.entity.UserSession;
import com.appliedsni.utility.Crypto;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	@Autowired
	com.appliedsni.security.jwtsecurity.security.JwtGenerator jwtGenerator;
	@Autowired
	UserAssembler userAssembler;
	@Override
	public UserLoginResponse loginUser(UserLoginRequest pUserLoginRequest) throws Exception {
		// TODO Auto-generated method stub
		UserLoginResponse userLoginResponse = new UserLoginResponse();
		List<User> user = userDao.findUserByEmail(pUserLoginRequest.getUserDto().getEmailAddress());
		User aUser = null;
		if (!CollectionUtils.isEmpty(user))
			aUser = user.get(0);
		final String pHasedPassword = Crypto.decrypt(aUser.getPasswordHash());
		if (!pHasedPassword.equals(pUserLoginRequest.getUserDto().getPasswordHash())) {
			userLoginResponse.setStatus("Fail");
			return userLoginResponse;
		} else {
			userLoginResponse.setStatus("Success");
			UserDto aUserDto = userAssembler.assembleUserDto(aUser);
			userLoginResponse.setUserDto(aUserDto);
			userLoginResponse.getRequestHeader().setToken(jwtGenerator.generate(aUserDto));
			UserSession userSession=new UserSession(aUser,userLoginResponse.getRequestHeader().getToken());
			userDao.create(userSession);
		}
		return userLoginResponse;
	}
	@Transactional
	public UserLoginResponse createUser(UserLoginRequest pUserLoginRequest) throws Exception
	{
		User aUser=userAssembler.assembleUser(pUserLoginRequest.getUserDto());
		aUser.setPasswordHash(Crypto.encrypt(aUser.getPasswordHash()));
		userDao.create(aUser);
		UserLoginResponse userLoginResponse = new UserLoginResponse();
		userLoginResponse.setStatus("User Created");
		return userLoginResponse;
	}

}
