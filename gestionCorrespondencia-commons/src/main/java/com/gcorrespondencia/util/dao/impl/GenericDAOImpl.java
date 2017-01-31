package com.gcorrespondencia.util.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.gcorrespondencia.util.dao.GenericDAO;


/**
 * @author Didier Fabian Silva Sanchez <didiersilva87@gmail.com>
 * @year 2016
 */
@Stateless
public class GenericDAOImpl<T> implements GenericDAO<T>, Serializable {

	private static final long serialVersionUID = -5483410655098186585L;

	private final static Logger log = Logger.getLogger(GenericDAOImpl.class
			.getName());

	@PersistenceContext(unitName = "gcorrespondenciaPU")
	private EntityManager em;
	private Class<T> type;

	public GenericDAOImpl() {
	}

	public GenericDAOImpl(Class<T> type) {
		this.type = type;
	}

	@Override
	@Transactional
	public Boolean add(T entidad) {
		try {
			this.em.persist(entidad);
			this.em.flush();
			this.em.refresh(entidad);
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Objeto guardado correctamente:  "
					+ entidad.getClass().getSimpleName());
			return true;
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al guardar el objeto en add, el error es el siguiente: "
					+ e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean addWithoutRefresh(T entidad) {
		try {
			this.em.persist(entidad);
			this.em.flush();
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Objeto guardado correctamente:  "
					+ entidad.getClass().getSimpleName());
			return true;
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al guardar el objeto en addWithoutRefresh, el error es el siguiente: "
					+ e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public Boolean edit(T entidad) {
		try {
			this.em.merge(entidad);
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Objeto actualizado correctamente:  "
					+ entidad.getClass().getSimpleName());
			return true;
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al actualizar el objeto en edit, el error es el siguiente: "
					+ e.getMessage());
			return false;
		}
	}

	@Override
	@Transactional
	public Boolean delete(T entidad) {
		try {

			T toBeRemoved = em.merge(entidad);
			em.remove(toBeRemoved);
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Objeto Eliminado correctamente:  "
					+ entidad.getClass().getSimpleName());
			return true;
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Eliminar el objeto en delete, el error es el siguiente: "
					+ e.getMessage());
			return false;
		}
	}

	@Override
	public T searchById(Class<T> claseEntidad, Object id) {
		try {
			return (T) this.em.find(claseEntidad, id);
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Hubo un error al obtener el objeto por Id en searchById, el error es el siguiente: "
					+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll(Class<T> claseEntidad) {
		StringBuilder jpql = new StringBuilder();
		try {
			jpql.append("SELECT myEntity FROM ");
			jpql.append(claseEntidad.getSimpleName());
			jpql.append(" myEntity ");
			Query query = this.em.createQuery(jpql.toString());
			return (List<T>) query.getResultList();
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Buscar todos los registros en searchAll, el error es el siguiente: "
					+ e.getMessage());
			return null;
		}
	}

	@Override
	public Long Count(Class<T> claseEntidad) {
		StringBuilder jpql = new StringBuilder();
		try {
			jpql.append("SELECT COUNT(myEntity) FROM ");
			jpql.append(claseEntidad.getSimpleName());
			jpql.append(" myEntity ");
			Query query = this.em.createQuery(jpql.toString());
			return (Long) query.getSingleResult();
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener la cantidad en Count, el error es el siguiente: "
					+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T searchLast(Class<T> claseEntidad) {
		StringBuilder jpql = new StringBuilder();
		try {
			jpql.append("SELECT MAX(miEntidad) FROM ");
			jpql.append(claseEntidad.getSimpleName());
			jpql.append(" miEntidad ");
			Query query = this.em.createQuery(jpql.toString());
			return (T) query.getSingleResult();
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener el ultimo elemento en searchLast, el error es el siguiente: "
					+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findWithNamedQuery(String namedQueryName) {
		try {
			Query query = this.em.createNamedQuery(namedQueryName);
			return (List) query.getResultList();
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener elementos en findWithNamedQuery, el error es el siguiente: "
					+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findWithNamedQuery(String namedQueryName, Map parameters) {
		try {
			return findWithNamedQuery(namedQueryName, parameters, 0);
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener elementos en findWithNamedQuery con Parametros, el error es el siguiente: "
					+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findWithNamedQuery(String queryName, int resultLimit) {
		try {
			Query query = this.em.createNamedQuery(queryName);
			return (List) query.setMaxResults(resultLimit).getResultList();
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener elementos en findWithNamedQuery con Limite, el error es el siguiente: "
					+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Override
	public List findByNativeQuery(String sql) {
		try {
			Query query = this.em.createNativeQuery(sql);
			List<Object> list = new ArrayList<>();
			return list = query.getResultList();
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener elementos en findByNativeQuery, el error es el siguiente: "
					+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNativeQueryWithClassReturn(String sql) {

		try {
			Query query = this.em.createNativeQuery(sql, type);
			return (List<T>) query.getResultList();
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener elementos en findByNativeQuery, el error es el siguiente: "
					+ e.getMessage());
			return null;
		}
	}

	@Override
	public Long countTotalRecord(String namedQueryName) {
		try {
			Query query = em.createNamedQuery(namedQueryName);
			return (Long) query.getSingleResult();
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener el Total de elemento en countTotalRecord, el error es el siguiente: "
					+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List findWithNamedQuery(String namedQueryName, Map parameters,
			int resultLimit) {
		try {
			Set<Map.Entry<String, Object>> rawParameters = parameters
					.entrySet();
			Query query = this.em.createNamedQuery(namedQueryName);
			if (resultLimit > 0) {
				query.setMaxResults(resultLimit);
			}
			for (Map.Entry<String, Object> entry : rawParameters) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
			return (List) query.getResultList();
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener elementos en findWithNamedQuery con Parametros y Limite, el error es el siguiente: "
					+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List findWithNamedQuery(String namedQueryName, Map parameters,
			int start, int end) {
		try {
			Set<Map.Entry<String, Object>> rawParameters = parameters
					.entrySet();
			Query query = this.em.createNamedQuery(namedQueryName);
			for (Map.Entry<String, Object> entry : rawParameters) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
			query.setMaxResults(end - start);
			query.setFirstResult(start);
			return (List) query.getResultList();
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener elementos en findWithNamedQuery con Parametros y Limite, el error es el siguiente: "
					+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findWithNamedQuery(String namedQueryName, int start, int end) {
		try {
			Query query = this.em.createNamedQuery(namedQueryName);
			query.setMaxResults(end - start);
			query.setFirstResult(start);
			return (List) query.getResultList();
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener elementos en findWithNamedQuery con Limite para paginado, el error es el siguiente: "
					+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAllWithOneArg(Class<T> claseEntidad, String parametro,
			String valor) {
		StringBuilder jpql = new StringBuilder();
		try {
			jpql.append("SELECT myEntity FROM ");
			jpql.append(claseEntidad.getSimpleName());
			jpql.append(" myEntity ");
			jpql.append(" WHERE " + parametro + " = '" + valor + "'");
			Query query = this.em.createQuery(jpql.toString());
			return (List<T>) query.getResultList();
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Buscar todos los registros en searchAll, el error es el siguiente: "
					+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T searchElementWithOneArg(Class<T> claseEntidad, String parametro,
			String valor) {
		StringBuilder jpql = new StringBuilder();
		log.info(" >>>>>>>>>>>>>>>>>>>>> Parametro  " + parametro);
		log.info(" >>>>>>>>>>>>>>>>>>>>> Valor  " + valor);
		try {
			jpql.append("SELECT myEntity FROM ");
			jpql.append(claseEntidad.getSimpleName());
			jpql.append(" myEntity ");
			jpql.append(" WHERE " + parametro + " = '" + valor + " '");
			Query query = this.em.createQuery(jpql.toString());
			List<T> results = query.getResultList();
			if (results.isEmpty()) {
				return null; // handle no-results case
			} else {
				return (T) results.get(0);
			}
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Buscar el Elemento en searchElementWithOneArg el error es el siguiente: "
					+ e.getMessage());
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public T searchElementWithOneArgInteger(Class<T> claseEntidad,
			String parametro, int valor) {
		StringBuilder jpql = new StringBuilder();
		try {
			jpql.append("SELECT myEntity FROM ");
			jpql.append(claseEntidad.getSimpleName());
			jpql.append(" myEntity ");
			jpql.append(" WHERE " + parametro + " = " + valor + " ");
			Query query = this.em.createQuery(jpql.toString());
			return (T) query.getSingleResult();
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>    "
					+ valor
					+ "    Hubo un error al Buscar el Elemento en searchElementWithOneArg el error es el siguiente: "
					+ e.getMessage());

			e.printStackTrace(System.out);
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public T searchElementWithOneArgLong(Class<T> claseEntidad,
			String parametro, long valor) {
		StringBuilder jpql = new StringBuilder();
		try {
			jpql.append("SELECT myEntity FROM ");
			jpql.append(claseEntidad.getSimpleName());
			jpql.append(" myEntity ");
			jpql.append(" WHERE " + parametro + " = " + valor + " ");
			Query query = this.em.createQuery(jpql.toString());
			// return (T) query.getSingleResult();
			List<T> results = query.getResultList();
			if (results.isEmpty()) {
				return null; // handle no-results case
			} else {
				return (T) results.get(0);
			}
		} catch (Exception e) {
			log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>    "
					+ valor
					+ "    Hubo un error al Buscar el Elemento en searchElementWithOneArg el error es el siguiente: "
					+ e.getMessage());

			e.printStackTrace(System.out);
			return null;
		}
	}
}
