package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_tipo_identificacion database table.
 * 
 */
@Entity
@Table(name="cat_tipo_identificacion")
@NamedQuery(name="CatTipoIdentificacion.findAll", query="SELECT c FROM CatTipoIdentificacion c")
public class CatTipoIdentificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TIPO_IDENTIFICACION")
	private int idTipoIdentificacion;

	@Column(name="CODIGO_TIPO_IDENTIFICACION")
	private String codigoTipoIdentificacion;

	@Column(name="DESCRIPCION_TIPO_IDENTIFICACION")
	private String descripcionTipoIdentificacion;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="catTipoIdentificacion")
	private List<Persona> personas;

	public CatTipoIdentificacion() {
	}

	public int getIdTipoIdentificacion() {
		return this.idTipoIdentificacion;
	}

	public void setIdTipoIdentificacion(int idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	public String getCodigoTipoIdentificacion() {
		return this.codigoTipoIdentificacion;
	}

	public void setCodigoTipoIdentificacion(String codigoTipoIdentificacion) {
		this.codigoTipoIdentificacion = codigoTipoIdentificacion;
	}

	public String getDescripcionTipoIdentificacion() {
		return this.descripcionTipoIdentificacion;
	}

	public void setDescripcionTipoIdentificacion(String descripcionTipoIdentificacion) {
		this.descripcionTipoIdentificacion = descripcionTipoIdentificacion;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setCatTipoIdentificacion(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setCatTipoIdentificacion(null);

		return persona;
	}

}