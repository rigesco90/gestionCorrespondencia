package com.gcorrespondencia.catalogos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.gcorrespondencia.bo.GenericBO;
import com.gcorrespondencia.entityes.CatNivelServicio;
import com.gcorrespondencia.entityes.CatServicio;
import com.gcorrespondencia.entityes.CatTipoReparto;

@ManagedBean (name="nivelServicioController")
@ViewScoped
public class NivelServiciosController {
	
	@EJB
	GenericBO genericBO;

	private CatNivelServicio nivelServicio;
	
	private List<CatServicio> listServicios;
	private List<CatTipoReparto> listTipoReparto;
	
	@PostConstruct
	public void init(){
		nivelServicio = new CatNivelServicio();
		nivelServicio.setCatTipoReparto(new CatTipoReparto());
		nivelServicio.setCatServicio(new CatServicio());
		
		listServicios = new ArrayList<CatServicio>();
		listTipoReparto = new ArrayList<CatTipoReparto>();
		listTipoReparto = new ArrayList<CatTipoReparto>();
		
		listServicios = genericBO.findAll(CatServicio.class);
		listTipoReparto = genericBO.findAll(CatTipoReparto.class);
	}
	
	public CatNivelServicio getNivelServicio() {
		return nivelServicio;
	}
	
	public void setNivelServicio(CatNivelServicio nivelServicio) {
		this.nivelServicio = nivelServicio;
	}
	
	public List<CatServicio> getListServicios() {
		return listServicios;
	}
	
	public void setListServicios(List<CatServicio> listServicio) {
		this.listServicios = listServicio;
	}
	
	public List<CatTipoReparto> getListTipoReparto() {
		return listTipoReparto;
	}
	
	public void setListTipoReparto(List<CatTipoReparto> listTipoReparto) {
		this.listTipoReparto = listTipoReparto;
	}
}
