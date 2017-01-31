package com.gcorrespondencia.dao.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.gcorrespondencia.dao.GQuery;
import com.gcorrespondencia.dao.GenericDAO;


public class GenericDAOJPAImpl implements GenericDAO {

	@PersistenceContext(unitName = "gcorrespondenciaPU")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAll(Class<?> clazz) {
		final String jpql = "SELECT tz FROM " + clazz.getSimpleName() + " tz order by tz.id";
		final Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<?> clazz, Object gquery) {
		GQuery query = (GQuery) gquery;
		Log.log(Level.INFO, "DBGMSG: GQUERY: "+query.getJPQL());
		final Query q = em.createQuery(query.getJPQL());
		for (int i = 0; i < query.getParams().size(); i++) {
			q.setParameter(query.getParams().get(i), query.getComparables().get(i));
		}

		return q.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> T find(Object gquery) {
		GQuery query = (GQuery) gquery;
		Log.log(Level.INFO, "DBGMSG: GQUERY: "+query.getJPQL());
		final Query q = em.createQuery(query.getJPQL());
		for (int i = 0; i < query.getParams().size(); i++) {
			q.setParameter(query.getParams().get(i), query.getComparables().get(i));
		}
		return (T) q.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAllJoinFetch(Class<?> clazz,String...  joins) {
		String strjoins = "";
		for(String join : joins){
			strjoins += "JOIN FETCH tz."+join+" ";
		}
		final String jpql = "SELECT tz FROM " + clazz.getSimpleName() + " tz "+ strjoins +" order by tz.id";
		final Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public <T> T edit(T arg0) {
		return em.merge(arg0);
	}

	@Override
	public void create(Object arg0) {	
		em.persist(arg0);
		this.em.flush();
		this.em.refresh(arg0);	
	}
	
	@Override
	public <T> T createReturnObject(T arg0) {	
		em.persist(arg0);
		this.em.flush();
		this.em.refresh(arg0);
		return arg0;
	}

	@Override
	public void delete(Class<?> type, Object id) {
		Object ref = this.em.getReference(type, id);
		this.em.remove(ref);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAllExceptId(Class<T> clazz, Object id) {
		final String jpql = "SELECT tz FROM " + clazz.getSimpleName() + " tz " +"WHERE tz.id != " +id;
		final Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	private static final Logger Log = Logger.getLogger(GenericDAOJPAImpl.class.getName());

	@SuppressWarnings("unchecked")
	@Override
	public <T> T searchObjectById(Class<T> clazz, int id) {
		final String jpql = "SELECT tz FROM " + clazz.getSimpleName() + " tz " +"WHERE tz.id = " +id;
		final Query query = em.createQuery(jpql);
		return (T) query.getSingleResult();		
	}
}
