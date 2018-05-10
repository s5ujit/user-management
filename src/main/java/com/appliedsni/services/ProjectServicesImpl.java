package com.appliedsni.services;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appliedsni.dao.ProjectDao;
import com.appliedsni.entity.Company;
import com.appliedsni.entity.Project;
import com.appliedsni.exception.DaoException;
@Service
public class ProjectServicesImpl implements ProjectServices{

	@Autowired
	ProjectDao projectDao;
	@Override
	@Transactional
	public Project createProject(Project pProject) throws Exception {
		Company company=new Company();
		company.setId(pProject.getCompany().getId());
		company=projectDao.findbyPK(company);
		pProject.setCompany(company);
		projectDao.create(pProject);
		return pProject;
	}

	@Override
	public Project findProjectById(long pId) throws DaoException {
		// TODO Auto-generated method stub
		Project project=new Project();
		project.setId(pId);
		return projectDao.findbyPK(project);
	}

	

}
