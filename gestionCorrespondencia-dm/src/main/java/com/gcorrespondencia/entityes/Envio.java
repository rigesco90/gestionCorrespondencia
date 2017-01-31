package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the envio database table.
 * 
 */
@Entity
@NamedQuery(name="Envio.findAll", query="SELECT e FROM Envio e")
public class Envio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ENVIO")
	private int idEnvio;

	@Column(name="CODIGO_ENVIO")
	private String codigoEnvio;

	@Column(name="DESCRIPCION_ENVIO")
	private String descripcionEnvio;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name="FECHA_ENTREGA")
	private Timestamp fechaEntrega;

	@Column(name="VALOR_ADICIONAL")
	private double valorAdicional;

	//bi-directional many-to-one association to CatEstado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_ESTADO_ID_ESTADO")
	private CatEstado catEstado;

	//bi-directional many-to-one association to CatZona
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_RUTA_ID_CAT_RUTA")
	private CatZona catZona;

	//bi-directional many-to-one association to Guia
	@ManyToOne(fetch=FetchType.LAZY)
	private Guia guia;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.LAZY)
	private Persona persona;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne(fetch=FetchType.LAZY)
	private Vehiculo vehiculo;

	//bi-directional many-to-one association to GuiaEnvio
	@OneToMany(mappedBy="envio")
	private List<GuiaEnvio> guiaEnvios;

	public Envio() {
	}

	public int getIdEnvio() {
		return this.idEnvio;
	}

	public void setIdEnvio(int idEnvio) {
		this.idEnvio = idEnvio;
	}

	public String getCodigoEnvio() {
		return this.codigoEnvio;
	}

	public void setCodigoEnvio(String codigoEnvio) {
		this.codigoEnvio = codigoEnvio;
	}

	public String getDescripcionEnvio() {
		return this.descripcionEnvio;
	}

	public void setDescripcionEnvio(String descripcionEnvio) {
		this.descripcionEnvio = descripcionEnvio;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaEntrega() {
		return this.fechaEntrega;
	}

	public void setFechaEntrega(Timestamp fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public double getValorAdicional() {
		return this.valorAdicional;
	}

	public void setValorAdicional(double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}

	public CatEstado getCatEstado() {
		return this.catEstado;
	}

	public void setCatEstado(CatEstado catEstado) {
		this.catEstado = catEstado;
	}

	public CatZona getCatZona() {
		return this.catZona;
	}

	public void setCatZona(CatZona catZona) {
		this.catZona = catZona;
	}

	public Guia getGuia() {
		return this.guia;
	}

	public void setGuia(Guia guia) {
		this.guia = guia;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<GuiaEnvio> getGuiaEnvios() {
		return this.guiaEnvios;
	}

	public void setGuiaEnvios(List<GuiaEnvio> guiaEnvios) {
		this.guiaEnvios = guiaEnvios;
	}

	public GuiaEnvio addGuiaEnvio(GuiaEnvio guiaEnvio) {
		getGuiaEnvios().add(guiaEnvio);
		guiaEnvio.setEnvio(this);

		return guiaEnvio;
	}

	public GuiaEnvio removeGuiaEnvio(GuiaEnvio guiaEnvio) {
		getGuiaEnvios().remove(guiaEnvio);
		guiaEnvio.setEnvio(null);

		return guiaEnvio;
	}

}