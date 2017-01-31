package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_tipo_persona database table.
 * 
 */
@Entity
@Table(name="cat_tipo_persona")
@NamedQuery(name="CatTipoPersona.findAll", query="SELECT c FROM CatTipoPersona c")
public class CatTipoPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TIPO_PERSONA")
	private int idTipoPersona;

	@Column(name="CODIGO_TIPO_PERSONA")
	private String codigoTipoPersona;

	@Column(name="DESCRIPCION_TIPO_PERSONA")
	private String descripcionTipoPersona;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to CatTipoPersona
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_TIPO_PERSONA_ID_TIPO_PERSONA")
	private CatTipoPersona catTipoPersona;

	//bi-directional many-to-one association to CatTipoPersona
	@OneToMany(mappedBy="catTipoPersona")
	private List<CatTipoPersona> catTipoPersonas;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="catTipoPersona")
	private List<Persona> personas;

	public CatTipoPersona() {
	}

	public int getIdTipoPersona() {
		return this.idTipoPersona;
	}

	public void setIdTipoPersona(int idTipoPersona) {
		this.idTipoPersona = idTipoPersona;
	}

	public String getCodigoTipoPersona() {
		return this.codigoTipoPersona;
	}

	public void setCodigoTipoPersona(String codigoTipoPersona) {
		this.codigoTipoPersona = codigoTipoPersona;
	}

	public String getDescripcionTipoPersona() {
		return this.descripcionTipoPersona;
	}

	public void setDescripcionTipoPersona(String descripcionTipoPersona) {
		this.descripcionTipoPersona = descripcionTipoPersona;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public CatTipoPersona getCatTipoPersona() {
		return this.catTipoPersona;
	}

	public void setCatTipoPersona(CatTipoPersona catTipoPersona) {
		this.catTipoPersona = catTipoPersona;
	}

	public List<CatTipoPersona> getCatTipoPersonas() {
		return this.catTipoPersonas;
	}

	public void setCatTipoPersonas(List<CatTipoPersona> catTipoPersonas) {
		this.catTipoPersonas = catTipoPersonas;
	}

	public CatTipoPersona addCatTipoPersona(CatTipoPersona catTipoPersona) {
		getCatTipoPersonas().add(catTipoPersona);
		catTipoPersona.setCatTipoPersona(this);

		return catTipoPersona;
	}

	public CatTipoPersona removeCatTipoPersona(CatTipoPersona catTipoPersona) {
		getCatTipoPersonas().remove(catTipoPersona);
		catTipoPersona.setCatTipoPersona(null);

		return catTipoPersona;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setCatTipoPersona(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setCatTipoPersona(null);

		return persona;
	}

}