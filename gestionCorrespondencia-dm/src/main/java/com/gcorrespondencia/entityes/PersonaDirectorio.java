package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the persona_directorio database table.
 * 
 */
@Entity
@Table(name="persona_directorio")
@NamedQuery(name="PersonaDirectorio.findAll", query="SELECT p FROM PersonaDirectorio p")
public class PersonaDirectorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PERSONA_DIRECTORIO")
	private int idPersonaDirectorio;

	@Column(name="COD_PERSONA_DIRECTORIO")
	private String codPersonaDirectorio;

	@Column(name="DESCRIPCION_PERSONA_DIRECTORIO")
	private String descripcionPersonaDirectorio;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to CatTipoTelefono
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_TIPO_TELEFONO_ID_TIPO_TELEFONO")
	private CatTipoTelefono catTipoTelefono;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.LAZY)
	private Persona persona;

	public PersonaDirectorio() {
	}

	public int getIdPersonaDirectorio() {
		return this.idPersonaDirectorio;
	}

	public void setIdPersonaDirectorio(int idPersonaDirectorio) {
		this.idPersonaDirectorio = idPersonaDirectorio;
	}

	public String getCodPersonaDirectorio() {
		return this.codPersonaDirectorio;
	}

	public void setCodPersonaDirectorio(String codPersonaDirectorio) {
		this.codPersonaDirectorio = codPersonaDirectorio;
	}

	public String getDescripcionPersonaDirectorio() {
		return this.descripcionPersonaDirectorio;
	}

	public void setDescripcionPersonaDirectorio(String descripcionPersonaDirectorio) {
		this.descripcionPersonaDirectorio = descripcionPersonaDirectorio;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public CatTipoTelefono getCatTipoTelefono() {
		return this.catTipoTelefono;
	}

	public void setCatTipoTelefono(CatTipoTelefono catTipoTelefono) {
		this.catTipoTelefono = catTipoTelefono;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}