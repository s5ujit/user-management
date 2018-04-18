package com.appliedsni.request.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.appliedsni.entity.User;
import com.appliedsni.exception.UserException;
@Service
public class UserRequestValidator {
	public void validateCreateUserRequest(User pUser) throws UserException
	{
		if(StringUtils.isEmpty(pUser.getEmailAddress()))
			throw new UserException("Email  requried");
		
		if(StringUtils.isEmpty(pUser.getFirstName()))
			throw new UserException("First name requried");
		
		if(StringUtils.isEmpty(pUser.getMobileNumber()))
			throw new UserException("Mobile number requried");
		
		if(StringUtils.isEmpty(pUser.getPasswordHash()))
			throw new UserException("Password requried");
		
	}
	public void validateLoginRequest(User pUser) throws UserException
	{
		if(StringUtils.isEmpty(pUser.getEmailAddress()))
			throw new UserException("Email  requried");
		
		if(StringUtils.isEmpty(pUser.getPasswordHash()))
			throw new UserException("Password requried");
		
	}

}
