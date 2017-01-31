package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the vitacora_guia database table.
 * 
 */
@Entity
@Table(name="vitacora_guia")
@NamedQuery(name="VitacoraGuia.findAll", query="SELECT v FROM VitacoraGuia v")
public class VitacoraGuia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_VITACORA_GUIA")
	private int idVitacoraGuia;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to CatEstado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_ESTADO_ID_ESTADO")
	private CatEstado catEstado;

	//bi-directional many-to-one association to Guia
	@ManyToOne(fetch=FetchType.LAZY)
	private Guia guia;

	public VitacoraGuia() {
	}

	public int getIdVitacoraGuia() {
		return this.idVitacoraGuia;
	}

	public void setIdVitacoraGuia(int idVitacoraGuia) {
		this.idVitacoraGuia = idVitacoraGuia;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public CatEstado getCatEstado() {
		return this.catEstado;
	}

	public void setCatEstado(CatEstado catEstado) {
		this.catEstado = catEstado;
	}

	public Guia getGuia() {
		return this.guia;
	}

	public void setGuia(Guia guia) {
		this.guia = guia;
	}

}