package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the guia_planilla database table.
 * 
 */
@Entity
@Table(name="guia_planilla")
@NamedQuery(name="GuiaPlanilla.findAll", query="SELECT g FROM GuiaPlanilla g")
public class GuiaPlanilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_GUIA_PLANILLA")
	private int idGuiaPlanilla;

	@Column(name="CODIGO_GUIA_PLANILLA")
	private String codigoGuiaPlanilla;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to Guia
	@ManyToOne(fetch=FetchType.LAZY)
	private Guia guia;

	//bi-directional many-to-one association to Planilla
	@ManyToOne(fetch=FetchType.LAZY)
	private Planilla planilla;

	//bi-directional many-to-one association to Prefactura
	@OneToMany(mappedBy="guiaPlanilla")
	private List<Prefactura> prefacturas;

	public GuiaPlanilla() {
	}

	public int getIdGuiaPlanilla() {
		return this.idGuiaPlanilla;
	}

	public void setIdGuiaPlanilla(int idGuiaPlanilla) {
		this.idGuiaPlanilla = idGuiaPlanilla;
	}

	public String getCodigoGuiaPlanilla() {
		return this.codigoGuiaPlanilla;
	}

	public void setCodigoGuiaPlanilla(String codigoGuiaPlanilla) {
		this.codigoGuiaPlanilla = codigoGuiaPlanilla;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Guia getGuia() {
		return this.guia;
	}

	public void setGuia(Guia guia) {
		this.guia = guia;
	}

	public Planilla getPlanilla() {
		return this.planilla;
	}

	public void setPlanilla(Planilla planilla) {
		this.planilla = planilla;
	}

	public List<Prefactura> getPrefacturas() {
		return this.prefacturas;
	}

	public void setPrefacturas(List<Prefactura> prefacturas) {
		this.prefacturas = prefacturas;
	}

	public Prefactura addPrefactura(Prefactura prefactura) {
		getPrefacturas().add(prefactura);
		prefactura.setGuiaPlanilla(this);

		return prefactura;
	}

	public Prefactura removePrefactura(Prefactura prefactura) {
		getPrefacturas().remove(prefactura);
		prefactura.setGuiaPlanilla(null);

		return prefactura;
	}

}