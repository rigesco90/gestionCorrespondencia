package com.gcorrespondencia.dao;

import java.util.List;


public interface GenericDAO{
	
	 public <T> List<T> findAll(Class<?> clazz);
	 
	 public <T> List<T> findAllJoinFetch(Class<?> clazz,String... joins);

	 public <T> T edit(T arg0); 

	 public void create(Object arg0);
	 
	 public <T> T createReturnObject(T arg0);

	 public void delete(Class<?> type, Object id);
	 
	 public <T> List<T> findAllExceptId(Class<T> clazz, Object id);

	 public <T> List<T> findAll(Class<?> clazz,Object query);

	 public <T> T find(Object query);
	 
	 public <T> T searchObjectById(Class<T> clazz, int id);
}
