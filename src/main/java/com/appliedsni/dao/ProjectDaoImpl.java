package com.appliedsni.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.appliedsni.entity.Project;
import com.appliedsni.exception.DaoException;
@Repository
public class ProjectDaoImpl extends BaseJpaDaoImpl implements ProjectDao {
   
	ProjectDao projectDao;
	public List<Project> findProjectByCompany(long pComapnyId) {
		Map<String, Object> map = new HashMap<>();
		map.put("pComapnyId", pComapnyId);
		final Query aquery = super.createQuery("select project from Project project where project.company.id = :pComapnyId",
				map);
		List<Project> li = aquery.getResultList();
		return li;

	}

	@Override
	public <T> T findChildbyPK(T pObject, long pOid) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project findProjectById(long pId) throws DaoException {
		// TODO Auto-generated method stub
		Project project=new Project();
		project.setId(pId);
		return projectDao.findbyPK(project);
	}

}
