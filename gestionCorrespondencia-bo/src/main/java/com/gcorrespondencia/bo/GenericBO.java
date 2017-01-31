package com.gcorrespondencia.bo;

import java.util.List;
import javax.ejb.Local;

@Local
public interface GenericBO {

	public <T> List<T> findAll(Class<T> clazz);
	
	public <T> List<T> findAllJoinFetch(Class<?> clazz,String...  joins);

	public <T> T edit(T arg0);
	
	public <T> T searchObjectById(Class<T> clazz, int id);

	void create(Object arg0);
	
	public <T> T createReturnObject(T arg0);

	public <T> void delete(Class<T> type, Object id);
	
	public <T> List<T> findAllExceptId(Class<T> clazz, Object id);

	public <T> List<T> findAll(Class<T> clazz,Object query);

	public <T> T find(Object query);

}
