package com.appliedsni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appliedsni.dao.ProjectDao;
import com.appliedsni.entity.Company;
import com.appliedsni.entity.Project;
import com.appliedsni.exception.DaoException;
import com.appliedsni.utility.ServerUrl;
@RestController
@RequestMapping(ServerUrl.ROOT_URL)
public class ProjectController {
	@Autowired
	ProjectDao projectDao;
	@GetMapping(value = ServerUrl.PROJECT)
	public Project findProjectById(@PathVariable("id") long id) throws DaoException {
		Project project=new Project();
		project.setId(id);
		project=projectDao.findbyPK(project);
		return project;
	}
	
	@GetMapping(value = ServerUrl.COMPANY_PROJECTS)
	public List<Project> findCompanyById(@PathVariable("companyId") long id) throws DaoException {
		
		return projectDao.findCompanyProjects(id);
	}

}
