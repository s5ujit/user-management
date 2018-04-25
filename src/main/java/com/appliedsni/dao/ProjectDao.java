package com.appliedsni.dao;

import java.util.List;

import com.appliedsni.entity.Project;
import com.appliedsni.exception.DaoException;

public interface ProjectDao  extends BaseJpaDao {

	Project findProjectById(long pId) throws DaoException;
	List<Project> findCompanyProjects(Long pId) throws DaoException;
}
