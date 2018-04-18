package com.appliedsni.services;


import com.appliedsni.entity.Project;
import com.appliedsni.exception.DaoException;

public interface ProjectServices {
	public Project createProject(Project pProject) throws Exception;
	public Project findProjectById(long pId) throws DaoException;

}
