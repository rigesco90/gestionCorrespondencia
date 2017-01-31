package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_mensajes database table.
 * 
 */
@Entity
@Table(name="cat_mensajes")
@NamedQuery(name="CatMensaje.findAll", query="SELECT c FROM CatMensaje c")
public class CatMensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MENSAJES")
	private int idMensajes;

	@Column(name="CODIGO_MENSAJES")
	private String codigoMensajes;

	@Column(name="DESCRIPCION_MENSAJES")
	private String descripcionMensajes;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to InconsistenciasValidacion
	@OneToMany(mappedBy="catMensaje")
	private List<InconsistenciasValidacion> inconsistenciasValidacions;

	public CatMensaje() {
	}

	public int getIdMensajes() {
		return this.idMensajes;
	}

	public void setIdMensajes(int idMensajes) {
		this.idMensajes = idMensajes;
	}

	public String getCodigoMensajes() {
		return this.codigoMensajes;
	}

	public void setCodigoMensajes(String codigoMensajes) {
		this.codigoMensajes = codigoMensajes;
	}

	public String getDescripcionMensajes() {
		return this.descripcionMensajes;
	}

	public void setDescripcionMensajes(String descripcionMensajes) {
		this.descripcionMensajes = descripcionMensajes;
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
		inconsistenciasValidacion.setCatMensaje(this);

		return inconsistenciasValidacion;
	}

	public InconsistenciasValidacion removeInconsistenciasValidacion(InconsistenciasValidacion inconsistenciasValidacion) {
		getInconsistenciasValidacions().remove(inconsistenciasValidacion);
		inconsistenciasValidacion.setCatMensaje(null);

		return inconsistenciasValidacion;
	}

}