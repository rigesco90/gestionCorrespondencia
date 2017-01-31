package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_departamento database table.
 * 
 */
@Entity
@Table(name="cat_departamento")
@NamedQuery(name="CatDepartamento.findAll", query="SELECT c FROM CatDepartamento c")
public class CatDepartamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DEPARTAMENTO")
	private int idDepartamento;

	@Column(name="CODIGO_DEPARTAMENTO")
	private String codigoDepartamento;

	@Column(name="DESCRIPCION_DEPARTAMENTO")
	private String descripcionDepartamento;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to CatMunicipio
	@OneToMany(mappedBy="catDepartamento")
	private List<CatMunicipio> catMunicipios;

	public CatDepartamento() {
	}

	public int getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getCodigoDepartamento() {
		return this.codigoDepartamento;
	}

	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public String getDescripcionDepartamento() {
		return this.descripcionDepartamento;
	}

	public void setDescripcionDepartamento(String descripcionDepartamento) {
		this.descripcionDepartamento = descripcionDepartamento;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<CatMunicipio> getCatMunicipios() {
		return this.catMunicipios;
	}

	public void setCatMunicipios(List<CatMunicipio> catMunicipios) {
		this.catMunicipios = catMunicipios;
	}

	public CatMunicipio addCatMunicipio(CatMunicipio catMunicipio) {
		getCatMunicipios().add(catMunicipio);
		catMunicipio.setCatDepartamento(this);

		return catMunicipio;
	}

	public CatMunicipio removeCatMunicipio(CatMunicipio catMunicipio) {
		getCatMunicipios().remove(catMunicipio);
		catMunicipio.setCatDepartamento(null);

		return catMunicipio;
	}

}