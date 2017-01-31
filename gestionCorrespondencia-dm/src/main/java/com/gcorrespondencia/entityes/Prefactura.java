package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the prefactura database table.
 * 
 */
@Entity
@NamedQuery(name="Prefactura.findAll", query="SELECT p FROM Prefactura p")
public class Prefactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PREFACTURA")
	private int idPrefactura;

	@Column(name="CODIGO_PREFACTURA")
	private String codigoPrefactura;

	@Column(name="DESCRIPCION_PREFACTURA")
	private String descripcionPrefactura;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to InconsistenciasValidacion
	@OneToMany(mappedBy="prefactura")
	private List<InconsistenciasValidacion> inconsistenciasValidacions;

	//bi-directional many-to-one association to GuiaPlanilla
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GUIA_PLANILLA_ID_GUIA_PLANILLA")
	private GuiaPlanilla guiaPlanilla;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.LAZY)
	private Persona persona;

	public Prefactura() {
	}

	public int getIdPrefactura() {
		return this.idPrefactura;
	}

	public void setIdPrefactura(int idPrefactura) {
		this.idPrefactura = idPrefactura;
	}

	public String getCodigoPrefactura() {
		return this.codigoPrefactura;
	}

	public void setCodigoPrefactura(String codigoPrefactura) {
		this.codigoPrefactura = codigoPrefactura;
	}

	public String getDescripcionPrefactura() {
		return this.descripcionPrefactura;
	}

	public void setDescripcionPrefactura(String descripcionPrefactura) {
		this.descripcionPrefactura = descripcionPrefactura;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<InconsistenciasValidacion> getInconsistenciasValidacions() {
		return this.inconsistenciasValidacions;
	}

	public void setInconsistenciasValidacions(List<InconsistenciasValidacion> inconsistenciasValidacions) {
		this.inconsistenciasValidacions = inconsistenciasValidacions;
	}

	public InconsistenciasValidacion addInconsistenciasValidacion(InconsistenciasValidacion inconsistenciasValidacion) {
		getInconsistenciasValidacions().add(inconsistenciasValidacion);
		inconsistenciasValidacion.setPrefactura(this);

		return inconsistenciasValidacion;
	}

	public InconsistenciasValidacion removeInconsistenciasValidacion(InconsistenciasValidacion inconsistenciasValidacion) {
		getInconsistenciasValidacions().remove(inconsistenciasValidacion);
		inconsistenciasValidacion.setPrefactura(null);

		return inconsistenciasValidacion;
	}

	public GuiaPlanilla getGuiaPlanilla() {
		return this.guiaPlanilla;
	}

	public void setGuiaPlanilla(GuiaPlanilla guiaPlanilla) {
		this.guiaPlanilla = guiaPlanilla;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}