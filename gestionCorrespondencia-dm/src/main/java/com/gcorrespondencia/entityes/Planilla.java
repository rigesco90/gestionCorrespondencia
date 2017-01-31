package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the planilla database table.
 * 
 */
@Entity
@NamedQuery(name="Planilla.findAll", query="SELECT p FROM Planilla p")
public class Planilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PLANILLA")
	private int idPlanilla;

	@Column(name="CODIGO_PLANILLA")
	private String codigoPlanilla;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name="TOTAL_UNIDADES")
	private int totalUnidades;

	//bi-directional many-to-one association to GuiaPlanilla
	@OneToMany(mappedBy="planilla")
	private List<GuiaPlanilla> guiaPlanillas;

	//bi-directional many-to-one association to CatEstado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_ESTADO_ID_ESTADO")
	private CatEstado catEstado;

	//bi-directional many-to-one association to Empresa
	@ManyToOne(fetch=FetchType.LAZY)
	private Empresa empresa;

	public Planilla() {
	}

	public int getIdPlanilla() {
		return this.idPlanilla;
	}

	public void setIdPlanilla(int idPlanilla) {
		this.idPlanilla = idPlanilla;
	}

	public String getCodigoPlanilla() {
		return this.codigoPlanilla;
	}

	public void setCodigoPlanilla(String codigoPlanilla) {
		this.codigoPlanilla = codigoPlanilla;
	}

	public Timestamp getFechaCreacion() {
		Date date = new Date();
		return new Timestamp(date.getTime());
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getTotalUnidades() {
		return this.totalUnidades;
	}

	public void setTotalUnidades(int totalUnidades) {
		this.totalUnidades = totalUnidades;
	}

	public List<GuiaPlanilla> getGuiaPlanillas() {
		return this.guiaPlanillas;
	}

	public void setGuiaPlanillas(List<GuiaPlanilla> guiaPlanillas) {
		this.guiaPlanillas = guiaPlanillas;
	}

	public GuiaPlanilla addGuiaPlanilla(GuiaPlanilla guiaPlanilla) {
		getGuiaPlanillas().add(guiaPlanilla);
		guiaPlanilla.setPlanilla(this);

		return guiaPlanilla;
	}

	public GuiaPlanilla removeGuiaPlanilla(GuiaPlanilla guiaPlanilla) {
		getGuiaPlanillas().remove(guiaPlanilla);
		guiaPlanilla.setPlanilla(null);

		return guiaPlanilla;
	}

	public CatEstado getCatEstado() {
		return this.catEstado;
	}

	public void setCatEstado(CatEstado catEstado) {
		this.catEstado = catEstado;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}