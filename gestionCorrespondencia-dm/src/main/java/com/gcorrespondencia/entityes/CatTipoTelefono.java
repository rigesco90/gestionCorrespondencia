package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_tipo_telefono database table.
 * 
 */
@Entity
@Table(name="cat_tipo_telefono")
@NamedQuery(name="CatTipoTelefono.findAll", query="SELECT c FROM CatTipoTelefono c")
public class CatTipoTelefono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TIPO_TELEFONO")
	private int idTipoTelefono;

	@Column(name="CODIGO_TIPO_TELEFONO")
	private String codigoTipoTelefono;

	@Column(name="DESCRIPCION_TIPO_TELEFONO")
	private String descripcionTipoTelefono;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to PersonaDirectorio
	@OneToMany(mappedBy="catTipoTelefono")
	private List<PersonaDirectorio> personaDirectorios;

	public CatTipoTelefono() {
	}

	public int getIdTipoTelefono() {
		return this.idTipoTelefono;
	}

	public void setIdTipoTelefono(int idTipoTelefono) {
		this.idTipoTelefono = idTipoTelefono;
	}

	public String getCodigoTipoTelefono() {
		return this.codigoTipoTelefono;
	}

	public void setCodigoTipoTelefono(String codigoTipoTelefono) {
		this.codigoTipoTelefono = codigoTipoTelefono;
	}

	public String getDescripcionTipoTelefono() {
		return this.descripcionTipoTelefono;
	}

	public void setDescripcionTipoTelefono(String descripcionTipoTelefono) {
		this.descripcionTipoTelefono = descripcionTipoTelefono;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<PersonaDirectorio> getPersonaDirectorios() {
		return this.personaDirectorios;
	}

	public void setPersonaDirectorios(List<PersonaDirectorio> personaDirectorios) {
		this.personaDirectorios = personaDirectorios;
	}

	public PersonaDirectorio addPersonaDirectorio(PersonaDirectorio personaDirectorio) {
		getPersonaDirectorios().add(personaDirectorio);
		personaDirectorio.setCatTipoTelefono(this);

		return personaDirectorio;
	}

	public PersonaDirectorio removePersonaDirectorio(PersonaDirectorio personaDirectorio) {
		getPersonaDirectorios().remove(personaDirectorio);
		personaDirectorio.setCatTipoTelefono(null);

		return personaDirectorio;
	}

}