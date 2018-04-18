package com.appliedsni.dao;

import java.util.List;

import com.appliedsni.entity.Project;
import com.appliedsni.exception.DaoException;

public interface ProjectDao  extends BaseJpaDao {
	public List<Project> findProjectByCompany( long pComapnyId) ;

	Project findProjectById(long pId) throws DaoException;
}
