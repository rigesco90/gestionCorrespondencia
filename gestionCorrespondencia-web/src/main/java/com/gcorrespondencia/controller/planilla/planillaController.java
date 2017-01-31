package com.gcorrespondencia.controller.planilla;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.TabChangeEvent;

import com.gcorrespondencia.bo.GenericBO;
import com.gcorrespondencia.bo.PlanillaBO;
import com.gcorrespondencia.entityes.CatDepartamento;
import com.gcorrespondencia.entityes.CatEstado;
import com.gcorrespondencia.entityes.CatMunicipio;
import com.gcorrespondencia.entityes.CatNivelServicio;
import com.gcorrespondencia.entityes.CatRangoPeso;
import com.gcorrespondencia.entityes.CatServicio;
import com.gcorrespondencia.entityes.CatTipoReparto;
import com.gcorrespondencia.entityes.Empresa;
import com.gcorrespondencia.entityes.Guia;
import com.gcorrespondencia.entityes.GuiaPlanilla;
import com.gcorrespondencia.entityes.Persona;
import com.gcorrespondencia.entityes.Planilla;

@ManagedBean(name = "planillaController")
@ViewScoped
public class planillaController implements Serializable {

	@EJB
	private transient GenericBO genericBO;

	@EJB
	private transient PlanillaBO planillaBo;

	private static final long serialVersionUID = -4549763901410768511L;
	private Empresa empresa;
	private CatEstado estado;
	private GuiaPlanilla guiaPlanilla;
	private Persona persona;

	private List<CatServicio> listServicios;
	private List<CatEstado> listEstados;
	private List<Persona> listPersonas;
	private List<CatRangoPeso> listRangoPesos;
	private List<CatMunicipio> listMunicipios;
	private List<CatDepartamento> listDeptos;
	private List<CatTipoReparto> listTipoReparto;

	@PostConstruct
	public void init() {
		System.out.println("Entro a init!!!");

		guiaPlanilla = new GuiaPlanilla();
		guiaPlanilla.setPlanilla(new Planilla());
		guiaPlanilla.setGuia(new Guia());

		guiaPlanilla.getPlanilla().setCatEstado(new CatEstado());
		guiaPlanilla.getPlanilla().setEmpresa(new Empresa());
		guiaPlanilla.getPlanilla().getEmpresa().setIdEmpresa(1);
		guiaPlanilla.getPlanilla().setEmpresa((Empresa) genericBO.findAllJoinFetch(Empresa.class, "direccion").get(0));

		guiaPlanilla.getGuia().setPersona1(new Persona());
		guiaPlanilla.getGuia().setPersona2(new Persona());
		guiaPlanilla.getGuia().setCatNivelServicio(new CatNivelServicio());
		guiaPlanilla.getGuia().getCatNivelServicio().setCatMunicipio(new CatMunicipio());
		guiaPlanilla.getGuia().getCatNivelServicio().getCatMunicipio().setCatDepartamento(new CatDepartamento());
		guiaPlanilla.getGuia().getCatNivelServicio().setCatTipoReparto(new CatTipoReparto());
		guiaPlanilla.getGuia().getCatNivelServicio().setCatServicio(new CatServicio());
		guiaPlanilla.getGuia().getCatNivelServicio().setCatRangoPeso(new CatRangoPeso());

		listEstados = planillaBo.estadosPlanilla();
		listPersonas = new ArrayList<Persona>();
		listServicios = new ArrayList<CatServicio>();
		listRangoPesos = new ArrayList<CatRangoPeso>();		
		listDeptos = new ArrayList<CatDepartamento>();
		listTipoReparto = new ArrayList<CatTipoReparto>();

		listServicios = genericBO.findAll(CatServicio.class);
		listPersonas = genericBO.findAll(Persona.class);
		listRangoPesos = genericBO.findAll(CatRangoPeso.class);
		listDeptos = genericBO.findAll(CatDepartamento.class);
		listTipoReparto = genericBO.findAll(CatTipoReparto.class);
	}

	public void prepareCreate() {
		System.out.println("entro a prepare create...");
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("./NuevaPlanilla.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Persona> completPersona(String query) {
		List<Persona> listPerson = new ArrayList<Persona>();
		String nombreCompleto = "";
		if (query != null && query.length() > 0 && listPersonas != null) {
			for (Persona per : listPersonas) {
				nombreCompleto = "";
				if (per.getPrimerNombre() != null && per.getPrimerApellido() != null) {
					nombreCompleto = per.getPrimerNombre().toUpperCase().concat(" ")
							.concat(per.getPrimerApellido().toUpperCase());
				}

				if (!(nombreCompleto.isEmpty())) {
					if (nombreCompleto.contains(query.toUpperCase())
							|| per.getNumIdentificacion().toUpperCase().contains(query.toUpperCase())) {
						listPerson.add(per);
					}
				} else if (per.getRazonSocial().toUpperCase().contains(query.toUpperCase())
						|| per.getNumIdentificacion().toUpperCase().contains(query.toUpperCase())) {
					listPerson.add(per);
				}
			}
		}
		return listPerson;
	}

	public List<CatRangoPeso> completRangoPesos(String query) {
		List<CatRangoPeso> listRangoPesoSugerido = new ArrayList<CatRangoPeso>();
		if (query.length() > 0) {
			for (CatRangoPeso catRangoPeso : listRangoPesos) {
				if (catRangoPeso.getDescripcionRangoPeso().toUpperCase().contains(query.toUpperCase())) {
					listRangoPesoSugerido.add(catRangoPeso);
				}
			}
		}
		return listRangoPesoSugerido;
	}

	public void listMunicipiosPorDepto() {
		if (guiaPlanilla.getGuia().getCatNivelServicio().getCatMunicipio().getCatDepartamento().getIdDepartamento() != 0) {
			int idDepto = guiaPlanilla.getGuia().getCatNivelServicio().getCatMunicipio().getCatDepartamento().getIdDepartamento();
			listMunicipios = new ArrayList<CatMunicipio>();
			listMunicipios = planillaBo.listMpiosPorDepto(idDepto);
		}
	}

	public void onTabChange(TabChangeEvent event) {
		// FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " +
		// event.getTab().getTitle());
		// FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void personaSeleccionada() {
		System.out.println("Persona seleccionada: " + persona.getDireccion() + " Identificacion: "
				+ persona.getNumIdentificacion());
	}

	public void GuardarServicios() {
		genericBO.create(guiaPlanilla.getGuia().getCatNivelServicio());
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public CatEstado getEstado() {
		return estado;
	}

	public void setEstado(CatEstado estado) {
		this.estado = estado;
	}

	public List<CatEstado> getListEstados() {
		return listEstados;
	}

	public void setListEstados(List<CatEstado> listEstado) {
		this.listEstados = listEstado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getListPersonas() {
		return listPersonas;
	}

	public void setListPersonas(List<Persona> listPersonas) {
		this.listPersonas = listPersonas;
	}

	public List<CatServicio> getListServicios() {
		return listServicios;
	}

	public void setListServicios(List<CatServicio> listServicios) {
		this.listServicios = listServicios;
	}

	public GuiaPlanilla getGuiaPlanilla() {
		return guiaPlanilla;
	}

	public void setGuiaPlanilla(GuiaPlanilla guiaPlanilla) {
		this.guiaPlanilla = guiaPlanilla;
	}
	
	public List<CatDepartamento> getListDeptos() {
		return listDeptos;
	}
	
	public void setListDeptos(List<CatDepartamento> listDeptos) {
		this.listDeptos = listDeptos;
	}

	public List<CatMunicipio> getListMunicipios() {
		return listMunicipios;
	}

	public void setListMunicipios(List<CatMunicipio> listMunicipios) {
		this.listMunicipios = listMunicipios;
	}
	
	public List<CatTipoReparto> getListTipoReparto() {
		return listTipoReparto;
	}
	
	public void setListTipoReparto(List<CatTipoReparto> listTipoReparto) {
		this.listTipoReparto = listTipoReparto;
	}

}
