package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_rango_peso database table.
 * 
 */
@Entity
@Table(name="cat_rango_peso")
@NamedQuery(name="CatRangoPeso.findAll", query="SELECT c FROM CatRangoPeso c")
public class CatRangoPeso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RANGO_PESO")
	private int idRangoPeso;

	@Column(name="CODIGO_RANGO_PESO")
	private String codigoRangoPeso;

	@Column(name="DESCRIPCION_RANGO_PESO")
	private String descripcionRangoPeso;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	private int maximo;

	private int minimo;

	//bi-directional many-to-one association to CatNivelServicio
	@OneToMany(mappedBy="catRangoPeso")
	private List<CatNivelServicio> catNivelServicios;

	public CatRangoPeso() {
	}

	public int getIdRangoPeso() {
		return this.idRangoPeso;
	}

	public void setIdRangoPeso(int idRangoPeso) {
		this.idRangoPeso = idRangoPeso;
	}

	public String getCodigoRangoPeso() {
		return this.codigoRangoPeso;
	}

	public void setCodigoRangoPeso(String codigoRangoPeso) {
		this.codigoRangoPeso = codigoRangoPeso;
	}

	public String getDescripcionRangoPeso() {
		return this.descripcionRangoPeso;
	}

	public void setDescripcionRangoPeso(String descripcionRangoPeso) {
		this.descripcionRangoPeso = descripcionRangoPeso;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getMaximo() {
		return this.maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public int getMinimo() {
		return this.minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public List<CatNivelServicio> getCatNivelServicios() {
		return this.catNivelServicios;
	}

	public void setCatNivelServicios(List<CatNivelServicio> catNivelServicios) {
		this.catNivelServicios = catNivelServicios;
	}

	public CatNivelServicio addCatNivelServicio(CatNivelServicio catNivelServicio) {
		getCatNivelServicios().add(catNivelServicio);
		catNivelServicio.setCatRangoPeso(this);

		return catNivelServicio;
	}

	public CatNivelServicio removeCatNivelServicio(CatNivelServicio catNivelServicio) {
		getCatNivelServicios().remove(catNivelServicio);
		catNivelServicio.setCatRangoPeso(null);

		return catNivelServicio;
	}

}