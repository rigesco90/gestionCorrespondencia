package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_servicios database table.
 * 
 */
@Entity
@Table(name="cat_servicios")
@NamedQuery(name="CatServicio.findAll", query="SELECT c FROM CatServicio c")
public class CatServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CAT_SERVICIOS")
	private int idCatServicios;

	@Column(name="CODIGO_CAT_SERVICIOS")
	private String codigoCatServicios;

	@Column(name="DESCRIPCION_CAT_SERVICIOS")
	private String descripcionCatServicios;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to CatNivelServicio
	@OneToMany(mappedBy="catServicio")
	private List<CatNivelServicio> catNivelServicios;

	public CatServicio() {
	}

	public int getIdCatServicios() {
		return this.idCatServicios;
	}

	public void setIdCatServicios(int idCatServicios) {
		this.idCatServicios = idCatServicios;
	}

	public String getCodigoCatServicios() {
		return this.codigoCatServicios;
	}

	public void setCodigoCatServicios(String codigoCatServicios) {
		this.codigoCatServicios = codigoCatServicios;
	}

	public String getDescripcionCatServicios() {
		return this.descripcionCatServicios;
	}

	public void setDescripcionCatServicios(String descripcionCatServicios) {
		this.descripcionCatServicios = descripcionCatServicios;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<CatNivelServicio> getCatNivelServicios() {
		return this.catNivelServicios;
	}

	public void setCatNivelServicios(List<CatNivelServicio> catNivelServicios) {
		this.catNivelServicios = catNivelServicios;
	}

	public CatNivelServicio addCatNivelServicio(CatNivelServicio catNivelServicio) {
		getCatNivelServicios().add(catNivelServicio);
		catNivelServicio.setCatServicio(this);

		return catNivelServicio;
	}

	public CatNivelServicio removeCatNivelServicio(CatNivelServicio catNivelServicio) {
		getCatNivelServicios().remove(catNivelServicio);
		catNivelServicio.setCatServicio(null);

		return catNivelServicio;
	}

}