package com.appliedsni.request.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.appliedsni.entity.Company;
import com.appliedsni.exception.UserException;
@Service
public class CompanyRequestValidator {
	public void createCompanyValidate(Company comapny) throws UserException{
		if(StringUtils.isEmpty(comapny.getName()))
			throw new UserException("Company name  requried");
	}

}
