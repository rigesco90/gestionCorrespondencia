package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the direccion database table.
 * 
 */
@Entity
@NamedQuery(name="Direccion.findAll", query="SELECT d FROM Direccion d")
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DIRECCION")
	private int idDireccion;

	@Column(name="CODIGO_DIRECCION")
	private String codigoDireccion;

	@Column(name="DESCRIPCION_DIRECCION")
	private String descripcionDireccion;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to CatBarrio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_BARRIO_ID_BARRIO")
	private CatBarrio catBarrio;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="direccion")
	private List<Empresa> empresas;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="direccion")
	private List<Persona> personas;

	public Direccion() {
	}

	public int getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCodigoDireccion() {
		return this.codigoDireccion;
	}

	public void setCodigoDireccion(String codigoDireccion) {
		this.codigoDireccion = codigoDireccion;
	}

	public String getDescripcionDireccion() {
		return this.descripcionDireccion;
	}

	public void setDescripcionDireccion(String descripcionDireccion) {
		this.descripcionDireccion = descripcionDireccion;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public CatBarrio getCatBarrio() {
		return this.catBarrio;
	}

	public void setCatBarrio(CatBarrio catBarrio) {
		this.catBarrio = catBarrio;
	}

	public List<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Empresa addEmpresa(Empresa empresa) {
		getEmpresas().add(empresa);
		empresa.setDireccion(this);

		return empresa;
	}

	public Empresa removeEmpresa(Empresa empresa) {
		getEmpresas().remove(empresa);
		empresa.setDireccion(null);

		return empresa;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setDireccion(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setDireccion(null);

		return persona;
	}

}