package com.appliedsni.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.appliedsni.dao.ProjectDao;
import com.appliedsni.entity.Company;
import com.appliedsni.entity.Project;
import com.appliedsni.exception.DaoException;
import com.appliedsni.utility.ServerUrl;

public class ProjectController {
	ProjectDao projectDao;
	@GetMapping(value = ServerUrl.PROJECT)
	public Project findProjectById(@PathVariable long id) throws DaoException {
		Project project=new Project();
		project.setId(id);
		project=projectDao.findbyPK(project);
		return project;
	}
	
	@GetMapping(value = ServerUrl.COMPANY_PROJECTS)
	public List<Project> findCompanyById(@PathVariable long id) throws DaoException {
		Project project=new Project();
		project.setId(id);
		project=projectDao.findbyPK(project);
		return projectDao.findCompanyProjects(id);
	}

}
