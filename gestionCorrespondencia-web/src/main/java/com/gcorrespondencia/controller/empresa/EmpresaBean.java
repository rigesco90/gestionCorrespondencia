//package com.gcorrespondencia.controller.empresa;
//
//import java.io.Serializable;
//import java.sql.Timestamp;
//import java.util.Date;
//import java.util.logging.Logger;
//
//import javax.annotation.PostConstruct;
//import javax.faces.bean.ManagedBean;
//import javax.inject.Inject;
//
//import com.gcorrespondencia.bo.EmpresaBO;
//import com.gcorrespondencia.entityes.Empresa;
//
//@ManagedBean(name = "empresaBean")
//public class EmpresaBean implements Serializable {
//
//	private static final long serialVersionUID = 8123774480834934193L;
//	
//	private final static Logger log = Logger.getLogger(EmpresaBean.class
//			.getName());
//	
//	@Inject
//	EmpresaBO empresaBO;
//	
//	private Empresa empresa;
//	
//	public EmpresaBean(){
//		empresa = new Empresa();
//	}
//	
//	@PostConstruct
//	public void init(){
//		log.info("°°°°° Entrando al Bean EmpresaBean °°°°°");
//	}
//	
//	public void agregarEmpresa(){
//		log.info(">>>>> Agregando una Empresa nueva...");
//		boolean result;
//		Date date1 = new Date();
//		Timestamp fecha = new Timestamp(date1.getTime());
//		empresa.setFechaCreacion(fecha);
//		result = empresaBO.crearEmpresa(empresa);
//		if(result){
//			log.info(">>>>>>>>>>>> Empresa guardada con exito...");
//		}else{
//			log.info(">>>>>>>>>>>> Se presento un error al guardar la empresa...");
//		}
//	}
//
//	public Empresa getEmpresa() {
//		return empresa;
//	}
//
//	public void setEmpresa(Empresa empresa) {
//		this.empresa = empresa;
//	}
//
//}
