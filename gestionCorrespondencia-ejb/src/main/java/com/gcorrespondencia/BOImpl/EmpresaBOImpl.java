//package com.gcorrespondencia.BOImpl;
//
//import java.io.Serializable;
//
//import javax.ejb.Stateless;
//import javax.inject.Inject;
//
//import com.gcorrespondencia.bo.EmpresaBO;
//import com.gcorrespondencia.dao.EmpresaDAO;
//import com.gcorrespondencia.entityes.Empresa;
//
//@Stateless
//public class EmpresaBOImpl implements EmpresaBO, Serializable{
//
//	private static final long serialVersionUID = 1238552118156915235L;
//	
//	@Inject
//	EmpresaDAO empresaDAO;
//
//	@Override
//	public boolean crearEmpresa(Empresa empresa) {
//		return empresaDAO.crearEmpresa(empresa);
//	}
//	
//
//}
