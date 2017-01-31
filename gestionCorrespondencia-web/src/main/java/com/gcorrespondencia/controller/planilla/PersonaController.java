package com.gcorrespondencia.controller.planilla;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.gcorrespondencia.bo.GenericBO;
import com.gcorrespondencia.bo.PersonaBO;
import com.gcorrespondencia.entityes.Persona;
import com.gcorrespondencia.util.ConstantesWeb;
import com.gcorrespondencia.util.Utilidad;
import com.gcorrespondencia.entityes.CatBarrio;
import com.gcorrespondencia.entityes.CatDepartamento;
import com.gcorrespondencia.entityes.CatMunicipio;
import com.gcorrespondencia.entityes.CatTipoIdentificacion;
import com.gcorrespondencia.entityes.CatTipoPersona;
import com.gcorrespondencia.entityes.Direccion;

@ManagedBean(name = "personaController")
@ViewScoped
public class PersonaController {

	@EJB
	private transient GenericBO genericBO;

	@EJB
	private transient PersonaBO personaBO;

	private Persona persona;
	private ConstantesWeb constWeb;

	private List<CatTipoPersona> listTipoPersona;
	private List<CatTipoIdentificacion> listTipoIdentificacion;
	private List<CatDepartamento> listDeptos;
	private List<CatMunicipio> listMpios;
	private List<CatBarrio> listBarrios;

	private boolean tipoPersona;

	@PostConstruct
	public void init() {
		System.out.println("Init personaController");
		persona = new Persona();
		persona.setDireccion(new Direccion());
		persona.getDireccion().setCatBarrio(new CatBarrio());
		persona.getDireccion().getCatBarrio().setCatMunicipio(new CatMunicipio());
		persona.getDireccion().getCatBarrio().getCatMunicipio().setCatDepartamento(new CatDepartamento());
		persona.setCatTipoPersona(new CatTipoPersona());
		persona.setCatTipoIdentificacion(new CatTipoIdentificacion());

		listTipoPersona = new ArrayList<CatTipoPersona>();
		listTipoIdentificacion = new ArrayList<CatTipoIdentificacion>();
		listDeptos = new ArrayList<CatDepartamento>();
		listMpios = new ArrayList<CatMunicipio>();
		listBarrios = new ArrayList<CatBarrio>();

		listTipoPersona = personaBO.listTipoPersona();
		listTipoIdentificacion = genericBO.findAll(CatTipoIdentificacion.class);
		listDeptos = genericBO.findAll(CatDepartamento.class);
	}

	public void validarTipoPersona() {
		tipoPersona = false;
		if (persona.getCatTipoPersona().getIdTipoPersona() != 0) {
			CatTipoPersona tipPersona = new CatTipoPersona();
			tipPersona = genericBO.searchObjectById(CatTipoPersona.class,
					persona.getCatTipoPersona().getIdTipoPersona());
			if (tipPersona.getCodigoTipoPersona().equals(ConstantesWeb.codigoPersonaJur)) {
				tipoPersona = true;
				
			} else {
				tipoPersona = false;
			}
			Utilidad.ejecutarUpdate(Utilidad.buscarHtmlComponete("pngPersonaNat").getClientId());
			Utilidad.ejecutarUpdate(Utilidad.buscarHtmlComponete("pngPersonaJur").getClientId());
		}
	}

	public void listMunicipiosPorDepto() {
		System.out.println("<< RCAMPO >>:: ID DEPTO: " );
		if (persona.getDireccion().getCatBarrio().getCatMunicipio().getCatDepartamento().getIdDepartamento() != 0) {
			int idDepto = persona.getDireccion().getCatBarrio().getCatMunicipio().getCatDepartamento()
					.getIdDepartamento();
			listMpios = personaBO.listMpiosPorDepto(idDepto);
			System.out.println("<< RCAMPO >>:: ID DEPTO: " + idDepto);
		}
	}

	public void listBarriosPorMpio() {
		if (persona.getDireccion().getCatBarrio().getCatMunicipio().getIdMunicipio() != 0) {
			int idMunicipio = persona.getDireccion().getCatBarrio().getCatMunicipio().getIdMunicipio();
			listBarrios = personaBO.listBarriosPorMupio(idMunicipio);
		}
	}

	public void listBarriosNuevo() {
		if (persona.getDireccion().getCatBarrio().getCatMunicipio().getIdMunicipio() != 0) {
			int idMunicipio = persona.getDireccion().getCatBarrio().getCatMunicipio().getIdMunicipio();
			listBarrios = personaBO.listBarriosPorMupioNuevo(idMunicipio);
		}
	}

	public List<CatBarrio> autocompletBarrio(String query) {
		List<CatBarrio> listAutocompletBarrio = new ArrayList<CatBarrio>();
		if (query != null && query.length() > 0 && listBarrios != null) {
			for (CatBarrio barrio : listBarrios) {
				if (barrio.getDescripcionBarrio().toUpperCase().contains(query.toUpperCase())) {
					listAutocompletBarrio.add(barrio);
				}
			}
		}
		return listAutocompletBarrio;
	}

	public void guardarBarrio() {
		CatBarrio barrio = new CatBarrio();
		barrio = genericBO.createReturnObject(persona.getDireccion().getCatBarrio());
		listBarrios.add(barrio);
		Utilidad.ejecutarUpdate(Utilidad.buscarHtmlComponete("pngAutcomBarrio").getClientId());
		Utilidad.ejecutarUpdate(Utilidad.buscarHtmlComponete("pngAutcomBarriopn").getClientId());
	}

	public void guardarPersona() {
		if (persona != null) {
			crearDireccion();
			genericBO.create(persona);
			init();
		}
	}

	public void crearDireccion() {
		persona.setDireccion(genericBO.createReturnObject(persona.getDireccion()));
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<CatTipoPersona> getListTipoPersona() {
		return listTipoPersona;
	}

	public void setListTipoPersona(List<CatTipoPersona> listTipoPersona) {
		this.listTipoPersona = listTipoPersona;
	}

	public List<CatTipoIdentificacion> getListTipoIdentificacion() {
		return listTipoIdentificacion;
	}

	public void setListTipoIdentificacion(List<CatTipoIdentificacion> listTipoIdentificacion) {
		this.listTipoIdentificacion = listTipoIdentificacion;
	}

	public ConstantesWeb getConstWeb() {
		return constWeb;
	}

	public void setConstWeb(ConstantesWeb constWeb) {
		this.constWeb = constWeb;
	}

	public void setTipoPersona(boolean tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public boolean isTipoPersona() {
		return tipoPersona;
	}

	public List<CatDepartamento> getListDeptos() {
		return listDeptos;
	}

	public void setListDeptos(List<CatDepartamento> listDeptos) {
		this.listDeptos = listDeptos;
	}

	public List<CatMunicipio> getListMpios() {
		return listMpios;
	}

	public void setListMpios(List<CatMunicipio> listMpios) {
		this.listMpios = listMpios;
	}

	public List<CatBarrio> getListBarrios() {
		return listBarrios;
	}

	public void setListBarrios(List<CatBarrio> listBarrios) {
		this.listBarrios = listBarrios;
	}

}
