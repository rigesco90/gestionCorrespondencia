package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_municipio database table.
 * 
 */
@Entity
@Table(name="cat_municipio")
@NamedQuery(name="CatMunicipio.findAll", query="SELECT c FROM CatMunicipio c")
public class CatMunicipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MUNICIPIO")
	private int idMunicipio;

	@Column(name="CAT_INDICATIVO_ID_INDICATIVO")
	private int catIndicativoIdIndicativo;

	@Column(name="CODIGO_MUNICIPIO")
	private String codigoMunicipio;

	@Column(name="DESCRIPCION_MUNICIPIO")
	private String descripcionMunicipio;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to CatBarrio
	@OneToMany(mappedBy="catMunicipio")
	private List<CatBarrio> catBarrios;

	//bi-directional many-to-one association to CatDepartamento
//	@ManyToOne(fetch=FetchType.LAZY)
	@ManyToOne(optional = false)
	@JoinColumn(name="CAT_DEPARTAMENTO_ID_DEPARTAMENTO")
	private CatDepartamento catDepartamento;

	//bi-directional many-to-one association to CatNivelServicio
	@OneToMany(mappedBy="catMunicipio")
	private List<CatNivelServicio> catNivelServicios;

	public CatMunicipio() {
	}

	public int getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public int getCatIndicativoIdIndicativo() {
		return this.catIndicativoIdIndicativo;
	}

	public void setCatIndicativoIdIndicativo(int catIndicativoIdIndicativo) {
		this.catIndicativoIdIndicativo = catIndicativoIdIndicativo;
	}

	public String getCodigoMunicipio() {
		return this.codigoMunicipio;
	}

	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public String getDescripcionMunicipio() {
		return this.descripcionMunicipio;
	}

	public void setDescripcionMunicipio(String descripcionMunicipio) {
		this.descripcionMunicipio = descripcionMunicipio;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<CatBarrio> getCatBarrios() {
		return this.catBarrios;
	}

	public void setCatBarrios(List<CatBarrio> catBarrios) {
		this.catBarrios = catBarrios;
	}

	public CatBarrio addCatBarrio(CatBarrio catBarrio) {
		getCatBarrios().add(catBarrio);
		catBarrio.setCatMunicipio(this);

		return catBarrio;
	}

	public CatBarrio removeCatBarrio(CatBarrio catBarrio) {
		getCatBarrios().remove(catBarrio);
		catBarrio.setCatMunicipio(null);

		return catBarrio;
	}

	public CatDepartamento getCatDepartamento() {
		return this.catDepartamento;
	}

	public void setCatDepartamento(CatDepartamento catDepartamento) {
		this.catDepartamento = catDepartamento;
	}

	public List<CatNivelServicio> getCatNivelServicios() {
		return this.catNivelServicios;
	}

	public void setCatNivelServicios(List<CatNivelServicio> catNivelServicios) {
		this.catNivelServicios = catNivelServicios;
	}

	public CatNivelServicio addCatNivelServicio(CatNivelServicio catNivelServicio) {
		getCatNivelServicios().add(catNivelServicio);
		catNivelServicio.setCatMunicipio(this);

		return catNivelServicio;
	}

	public CatNivelServicio removeCatNivelServicio(CatNivelServicio catNivelServicio) {
		getCatNivelServicios().remove(catNivelServicio);
		catNivelServicio.setCatMunicipio(null);

		return catNivelServicio;
	}

}