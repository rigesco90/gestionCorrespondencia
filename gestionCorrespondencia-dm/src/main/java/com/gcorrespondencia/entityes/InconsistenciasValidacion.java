package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the inconsistencias_validacion database table.
 * 
 */
@Entity
@Table(name="inconsistencias_validacion")
@NamedQuery(name="InconsistenciasValidacion.findAll", query="SELECT i FROM InconsistenciasValidacion i")
public class InconsistenciasValidacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_INCONSISTENCIAS_VALIDACION")
	private int idInconsistenciasValidacion;

	@Column(name="DEBE_DECIR")
	private String debeDecir;

	private String dice;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to CatMensaje
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_MENSAJES_ID_MENSAJES")
	private CatMensaje catMensaje;

	//bi-directional many-to-one association to Prefactura
	@ManyToOne(fetch=FetchType.LAZY)
	private Prefactura prefactura;

	public InconsistenciasValidacion() {
	}

	public int getIdInconsistenciasValidacion() {
		return this.idInconsistenciasValidacion;
	}

	public void setIdInconsistenciasValidacion(int idInconsistenciasValidacion) {
		this.idInconsistenciasValidacion = idInconsistenciasValidacion;
	}

	public String getDebeDecir() {
		return this.debeDecir;
	}

	public void setDebeDecir(String debeDecir) {
		this.debeDecir = debeDecir;
	}

	public String getDice() {
		return this.dice;
	}

	public void setDice(String dice) {
		this.dice = dice;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public CatMensaje getCatMensaje() {
		return this.catMensaje;
	}

	public void setCatMensaje(CatMensaje catMensaje) {
		this.catMensaje = catMensaje;
	}

	public Prefactura getPrefactura() {
		return this.prefactura;
	}

	public void setPrefactura(Prefactura prefactura) {
		this.prefactura = prefactura;
	}

}