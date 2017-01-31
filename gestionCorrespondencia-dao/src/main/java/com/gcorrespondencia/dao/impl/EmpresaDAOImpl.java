//package com.gcorrespondencia.dao.impl;
//
//import java.io.Serializable;
//import java.util.logging.Logger;
//
//import javax.ejb.Stateless;
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import com.gcorrespondencia.dao.EmpresaDAO;
//import com.gcorrespondencia.entityes.Empresa;
//import com.gcorrespondencia.util.dao.GenericDAO;
//
//@Stateless
//public class EmpresaDAOImpl implements EmpresaDAO,Serializable {
//
//	private static final long serialVersionUID = 6289246222556928192L;
//	
//	private static final Logger log = Logger.getLogger(EmpresaDAOImpl.class.getName());
//	
//	@PersistenceContext(unitName = "gcorrespondenciaPU")
//	private EntityManager em;
//	
//	@Inject
//	GenericDAO<Empresa> emEmpresa;
//
//	@Override
//	public boolean crearEmpresa(Empresa empresa) {
//		log.info("°°°°° Agregando Empresa nueva a la base de datos °°°°°");
//		return emEmpresa.add(empresa);
//	}
//
//}
