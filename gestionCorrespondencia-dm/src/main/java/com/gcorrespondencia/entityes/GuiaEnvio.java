package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the guia_envio database table.
 * 
 */
@Entity
@Table(name="guia_envio")
@NamedQuery(name="GuiaEnvio.findAll", query="SELECT g FROM GuiaEnvio g")
public class GuiaEnvio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_GUIA_ENVIO")
	private int idGuiaEnvio;

	@Column(name="CODIGO_GUIA_ENVIO")
	private String codigoGuiaEnvio;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	private double valor;

	//bi-directional many-to-one association to Envio
	@ManyToOne(fetch=FetchType.LAZY)
	private Envio envio;

	//bi-directional many-to-one association to Guia
	@ManyToOne(fetch=FetchType.LAZY)
	private Guia guia;

	public GuiaEnvio() {
	}

	public int getIdGuiaEnvio() {
		return this.idGuiaEnvio;
	}

	public void setIdGuiaEnvio(int idGuiaEnvio) {
		this.idGuiaEnvio = idGuiaEnvio;
	}

	public String getCodigoGuiaEnvio() {
		return this.codigoGuiaEnvio;
	}

	public void setCodigoGuiaEnvio(String codigoGuiaEnvio) {
		this.codigoGuiaEnvio = codigoGuiaEnvio;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Envio getEnvio() {
		return this.envio;
	}

	public void setEnvio(Envio envio) {
		this.envio = envio;
	}

	public Guia getGuia() {
		return this.guia;
	}

	public void setGuia(Guia guia) {
		this.guia = guia;
	}

}