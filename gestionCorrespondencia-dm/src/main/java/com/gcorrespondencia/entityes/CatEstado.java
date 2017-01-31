package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_estado database table.
 * 
 */
@Entity
@Table(name="cat_estado")
@NamedQuery(name="CatEstado.findAll", query="SELECT c FROM CatEstado c")
public class CatEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ESTADO")
	private int idEstado;

	@Column(name="CODIGO_ESTADO")
	private String codigoEstado;

	@Column(name="DESCRIPCION_ESTADO")
	private String descripcionEstado;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to CatCabEstado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_CAB_ESTADO_IDCAT_CAB_ESTADO")
	private CatCabEstado catCabEstado;

	//bi-directional many-to-one association to CatMenu
	@OneToMany(mappedBy="catEstado")
	private List<CatMenu> catMenus;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="catEstado")
	private List<Envio> envios;

	//bi-directional many-to-one association to Planilla
	@OneToMany(mappedBy="catEstado")
	private List<Planilla> planillas;

	//bi-directional many-to-one association to VitacoraGuia
	@OneToMany(mappedBy="catEstado")
	private List<VitacoraGuia> vitacoraGuias;

	public CatEstado() {
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getCodigoEstado() {
		return this.codigoEstado;
	}

	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public String getDescripcionEstado() {
		return this.descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public CatCabEstado getCatCabEstado() {
		return this.catCabEstado;
	}

	public void setCatCabEstado(CatCabEstado catCabEstado) {
		this.catCabEstado = catCabEstado;
	}

	public List<CatMenu> getCatMenus() {
		return this.catMenus;
	}

	public void setCatMenus(List<CatMenu> catMenus) {
		this.catMenus = catMenus;
	}

	public CatMenu addCatMenus(CatMenu catMenus) {
		getCatMenus().add(catMenus);
		catMenus.setCatEstado(this);

		return catMenus;
	}

	public CatMenu removeCatMenus(CatMenu catMenus) {
		getCatMenus().remove(catMenus);
		catMenus.setCatEstado(null);

		return catMenus;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setCatEstado(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setCatEstado(null);

		return envio;
	}

	public List<Planilla> getPlanillas() {
		return this.planillas;
	}

	public void setPlanillas(List<Planilla> planillas) {
		this.planillas = planillas;
	}

	public Planilla addPlanilla(Planilla planilla) {
		getPlanillas().add(planilla);
		planilla.setCatEstado(this);

		return planilla;
	}

	public Planilla removePlanilla(Planilla planilla) {
		getPlanillas().remove(planilla);
		planilla.setCatEstado(null);

		return planilla;
	}

	public List<VitacoraGuia> getVitacoraGuias() {
		return this.vitacoraGuias;
	}

	public void setVitacoraGuias(List<VitacoraGuia> vitacoraGuias) {
		this.vitacoraGuias = vitacoraGuias;
	}

	public VitacoraGuia addVitacoraGuia(VitacoraGuia vitacoraGuia) {
		getVitacoraGuias().add(vitacoraGuia);
		vitacoraGuia.setCatEstado(this);

		return vitacoraGuia;
	}

	public VitacoraGuia removeVitacoraGuia(VitacoraGuia vitacoraGuia) {
		getVitacoraGuias().remove(vitacoraGuia);
		vitacoraGuia.setCatEstado(null);

		return vitacoraGuia;
	}

}