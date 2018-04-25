package com.appliedsni.services;

import java.util.List;




import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.appliedsni.dao.ProfileDao;
import com.appliedsni.dao.ProjectDao;
import com.appliedsni.dao.TokenDao;
import com.appliedsni.dao.UserDao;
import com.appliedsni.entity.Company;
import com.appliedsni.entity.Project;
import com.appliedsni.entity.User;
import com.appliedsni.entity.UserSession;
import com.appliedsni.exception.DaoException;
import com.appliedsni.exception.UserException;
import com.appliedsni.request.validator.UserRequestValidator;
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
	@Autowired
	UserRequestValidator userRequestValidator;
	@Autowired
	ProjectDao projectDao;
	@Override
	@Transactional
	public User loginUser(User pUser,HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		userRequestValidator.validateLoginRequest(pUser);;
		User aUser = findUserByEmailId(pUser.getEmailAddress());
		final String pHasedPassword = Crypto.decrypt(aUser.getPasswordHash());
		if (!pHasedPassword.equals(pUser.getPasswordHash())) {
			throw new RuntimeException("");
		} else {
			
			String token=jwtGenerator.generate(aUser);
			response.setHeader("Authorisation", token);
			//response.addHeader("Authorisation", token);
			UserSession userSession=new UserSession(token,aUser.getEmailAddress());
			userDao.create(userSession);
		}
		aUser.setCompany(null);
		return aUser;
	}
	public User findUserByEmailId(String pEmailId)
	{
		List<User> user = userDao.findUserByEmail(pEmailId);
		User aUser = null;
		if (!CollectionUtils.isEmpty(user))
			aUser = user.get(0);
		if(aUser==null)
			throw new RuntimeException("User not esxit");
		return aUser;
		
	}
	@Transactional
	public User createUser(User pUser) throws Exception
	{
		userRequestValidator.validateCreateUserRequest(pUser);
		pUser.setPasswordHash(Crypto.encrypt(pUser.getPasswordHash()));
		pUser.setProfile(this.profileDao.findByProfileId("DEFAULT"));
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
		tokenDao.deleteToken(pUserId, pToken);
		
	}
	@Override
	public void logout(User pUserLoginRequest) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<User> findUsers()
	{
		List<User> userList=userDao.findUserList();
		return userList;
	}
	@Override
	public List<Project> getProjectList(long pUserId) {
		// TODO Auto-generated method stub
		 return  userDao.getProjectList(pUserId);
	}
	@Override
	public List<Company> getCompanyList(long pUserId) {
		// TODO Auto-generated method stub
		return userDao.getComapnyList(pUserId);
	}
	@Override
	@Transactional
	public void updateUser(long pUserId,User pUser) throws DaoException, UserException {
		// TODO Auto-generated method stub
		User user=new User();
		user.setId(pUserId);
		User aUser=userDao.findbyPK(user);
		if(aUser==null)
			throw new UserException("User not found");
		if(!CollectionUtils.isEmpty(pUser.getProject()))
		{
			for(Project project:pUser.getProject())
			{
				aUser.getProject().add(projectDao.findbyPK(project));
			}
			
		}
		if(!CollectionUtils.isEmpty(pUser.getCompany()))
		{
			for(Company company:pUser.getCompany())
			{
				aUser.getCompany().add(projectDao.findbyPK(company));
			}
			
		}
		userDao.mergeManaged(aUser);
	}
	@Override
	public User findById(long pUserId) throws DaoException {
		// TODO Auto-generated method stub
		User user=new User();
		user.setId(pUserId);
		user=userDao.findbyPK(user);
		return user;
	}
	
	
	

}
