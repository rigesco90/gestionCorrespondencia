package com.gcorrespondencia.BOImpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.gcorrespondencia.bo.GenericBO;
import com.gcorrespondencia.dao.GenericDAO;

@Stateless
public class GenericEJB implements GenericBO{

	@Inject
	private GenericDAO genericDAO;

	@Override
	 public <T> List<T> findAll(Class<T> clazz) {
	  return genericDAO.findAll(clazz);
	 }
	
	@Override
	 public <T> List<T> findAll(Class<T> clazz,Object query) { 
	  return genericDAO.findAll(clazz,query);
	 }
	
	@Override
	 public <T> T find(Object query) {
	  return genericDAO.find(query);
	 }
	
	@Override
	public <T> List<T> findAllJoinFetch(Class<?> clazz,String...  joins){
		return genericDAO.findAllJoinFetch(clazz, joins);
	}

	@Override
	public <T> T edit(T arg0) {
		return genericDAO.edit(arg0);
	}

	@Override
	public void create(Object arg0) {
		genericDAO.create(arg0);		
	}

	@Override
	public <T> void delete(Class<T> type, Object id) {
		genericDAO.delete(type, id);		
	}

	@Override
	public <T> List<T> findAllExceptId(Class<T> clazz, Object id) {		
		return genericDAO.findAllExceptId(clazz, id);
	}

	@Override
	public <T> T searchObjectById(Class<T> clazz, int id) {		
		return genericDAO.searchObjectById(clazz, id);
	}

	@Override
	public <T> T createReturnObject(T arg0) {		
		return genericDAO.createReturnObject(arg0);
	}
}
