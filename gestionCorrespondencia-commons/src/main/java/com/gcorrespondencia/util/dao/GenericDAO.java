package com.gcorrespondencia.util.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

/**
 * @author Didier Fabian Silva Sanchez <didiersilva87@gmail.com>
 * @year 2016
 */

@Local
public interface GenericDAO<T> {

	/**
	 * Crea un registro en la base de datos.
	 * 
	 * @param entidad
	 *            objeto a almacenar.
	 * @return resultado verdadero o falso
	 */
	public Boolean add(T entidad);

	/**
	 * Similar a la función anterior, solo que evitando hacer un refresh despues
	 * de persistir la entidad.
	 * 
	 * @param entidad
	 * @return
	 */
	public Boolean addWithoutRefresh(T entidad);

	/**
	 * Modifica un registro en la base de datos.
	 * 
	 * @param entidad
	 * @return resultado verdadero o falso.
	 */
	public Boolean edit(T entidad);

	/**
	 * Elimina un registro en la bse de datos.
	 * 
	 * @param entidad
	 * @return resultado verdadero o falso.
	 */
	public Boolean delete(T entidad);

	/**
	 * Busca un registro en la base de datos por su id
	 * 
	 * @param claseEntidad
	 *            Nombre simple de la entidad.
	 * @param id
	 *            Identificador del objeto.
	 * @return T objeto buscado.
	 */
	public T searchById(Class<T> claseEntidad, Object id);

	/**
	 * Busca todos los registros de una entidad.
	 * 
	 * @param claseEntidad
	 *            Nombre simple de la entidad.
	 * @return List<T> lista de objetos buscados.
	 */
	public List<T> searchAll(Class<T> claseEntidad);

	/**
	 * Devuelve la cantidad de registros de una entidad
	 * 
	 * @param claseEntidad
	 *            Nombre simple de la entidad
	 * @return numeroRegistros
	 */
	public Long Count(Class<T> claseEntidad);

	/**
	 * Busca el ultimo objeto agregado en una entidad.
	 * 
	 * @param claseEntidad
	 *            Nombre simple de la entidad.
	 * @return T ultimo objeto ingresado.
	 */
	public T searchLast(Class<T> claseEntidad);

	/**
	 * Devuelve una lista de registros definida en el namedQuery
	 * 
	 * @param namedQueryName
	 * @return List
	 */
	public List findWithNamedQuery(String namedQueryName);

	/**
	 * Devuelve una lista de registros definida en el namedQuery, recibe los
	 * parametros del query
	 * 
	 * @param namedQueryName
	 * @param parameters
	 * @return List
	 */
	public List findWithNamedQuery(String namedQueryName, Map parameters);

	/**
	 * Devuelve una lista de registros definida en el namedQuery, tiene un
	 * limite de registros a devolver
	 * 
	 * @param queryName
	 * @param resultLimit
	 * @return List
	 */
	public List findWithNamedQuery(String queryName, int resultLimit);

	/**
	 * Devuelve una lista de registros definida en un NativeQuery con la clase
	 * definida para retornar los elementos, en este caso es la clase que se
	 * define al crear la instancia de la persistencia
	 * 
	 * @param <T>
	 * @param sql
	 * @param type
	 * @return List
	 */
	public List<T> findByNativeQueryWithClassReturn(String sql);

	/**
	 * Devuelve una lista de registros definida en un NativeQuery
	 * 
	 * @param <T>
	 * @param sql
	 * @param type
	 * @return List
	 */
	public List<T> findByNativeQuery(String sql);

	/**
	 * Devuelve el total de registros de una namedQuery
	 * 
	 * @param namedQueryName
	 * @return Long
	 */
	public Long countTotalRecord(String namedQueryName);

	/**
	 * Devuelve una lista con los registros definidos en el namedQuery,
	 * pasandole los parametros y definiendole un limite de registros a
	 * devolver.
	 * 
	 * @param namedQueryName
	 * @param parameters
	 * @param resultLimit
	 * @return List
	 */
	public List findWithNamedQuery(String namedQueryName, Map parameters,
			int resultLimit);

	/**
	 * Devuelve una lista con los registros definidos en el namedQuery,
	 * pasandole los parametros y definiendole un limite inferior y superior de
	 * registros a devolver.
	 * 
	 * @param namedQueryName
	 * @param parameters
	 * @param resultLimit
	 * @return List
	 */
	public List findWithNamedQuery(String namedQueryName, Map parameters,
			int start, int end);

	/**
	 * Returns the number of records that will be used with lazy loading /
	 * pagination
	 * 
	 * @param namedQueryName
	 * @param start
	 * @param end
	 * @return List
	 */
	public List findWithNamedQuery(String namedQueryName, int start, int end);

	/**
	 * Funcion encargad de traer una lista de objetos de una entidad definida,
	 * ingresando el nombre del parametro y el valor de ese parametro, tener en
	 * cuenta que debe ser de tipo String, en caso dado que el valor que se esta
	 * dando sea de otro tipo, modificar este metodo a conveniencia.
	 * 
	 * @param claseEntidad
	 * @param parametro
	 * @param valor
	 * @return Lista de objetos encontrados según lo especificado
	 */

	public List<T> searchAllWithOneArg(Class<T> claseEntidad, String parametro,
			String valor);

	/**
	 * 
	 * Funcion encargada de retornar un objeto de una entidad determinada segun
	 * el parametro buscado
	 * 
	 * @param claseEntidad
	 *            Nombre Entidad.class
	 * @param parametro
	 *            Nombre de la propiedad
	 * @param valor
	 *            Valor de la propiedad (Debe ser de tipo String)
	 * @return Objeto encontrado
	 */

	public T searchElementWithOneArg(Class<T> claseEntidad, String parametro,
			String valor);

	/**
	 * 
	 * Funcion encargada de retornar un objeto de una entidad determinada segun
	 * el parametro buscado
	 * 
	 * @param claseEntidad
	 *            Nombre Entidad.class
	 * @param parametro
	 *            Nombre de la propiedad
	 * @param valor
	 *            Valor de la propiedad (Debe ser de tipo int)
	 * @return Objeto encontrado
	 */
	public T searchElementWithOneArgInteger(Class<T> claseEntidad,
			String parametro, int valor);

	/**
	 * 
	 * Funcion encargada de retornar un objeto de una entidad determinada segun
	 * el parametro buscado
	 * 
	 * @param claseEntidad
	 *            Nombre Entidad.class
	 * @param parametro
	 *            Nombre de la propiedad
	 * @param valor
	 *            Valor de la propiedad (Debe ser de tipo long)
	 * @return Objeto encontrado
	 */

	public T searchElementWithOneArgLong(Class<T> claseEntidad,
			String parametro, long valor);
}