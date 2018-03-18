package com.appliedsni.services.user;

import java.util.List;


import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.appliedsni.dao.ProfileDao;
import com.appliedsni.dao.TokenDao;
import com.appliedsni.dao.UserDao;
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
	ProfileDao profileDao;
	@Autowired
	TokenDao tokenDao;
	@Override
	@Transactional
	public User loginUser(User pUser,HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<User> user = userDao.findUserByEmail(pUser.getEmailAddress());
		User aUser = null;
		if (!CollectionUtils.isEmpty(user))
			aUser = user.get(0);
		final String pHasedPassword = Crypto.decrypt(aUser.getPasswordHash());
		if (!pHasedPassword.equals(pUser.getPasswordHash())) {
			throw new RuntimeException("");
		} else {
			
			String token=jwtGenerator.generate(user.get(0));
			response.setHeader("Authorisation", token);
			UserSession userSession=new UserSession(token,aUser.getEmailAddress());
			userDao.create(userSession);
		}
		return aUser;
	}
	@Transactional
	public User createUser(User pUser) throws Exception
	{
		pUser.setPasswordHash(Crypto.encrypt(pUser.getPasswordHash()));
		pUser.setProfile(this.profileDao.findByProfileId(pUser.getProfile().getRole()));
		userDao.create(pUser);
		return pUser;
	}
	
	public void isVlaidSession(String pUserId,String pToken) throws Exception{
		
		Long count=tokenDao.isTokenValid(pUserId, pToken);
		if(count<1)
		{
			throw new RuntimeException("Invalid session");
		}
	}
	@Override
	public void deleteSession(String pUserId, String pToken) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void logout(User pUserLoginRequest) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
