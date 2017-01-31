package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_tipo_reparto database table.
 * 
 */
@Entity
@Table(name="cat_tipo_reparto")
@NamedQuery(name="CatTipoReparto.findAll", query="SELECT c FROM CatTipoReparto c")
public class CatTipoReparto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CAT_TIPO_REPARTO")
	private int idCatTipoReparto;

	@Column(name="CODIGO_TIPO_REPARTO")
	private String codigoTipoReparto;

	@Column(name="DESCRIPCION_TIPO_REPARTO")
	private String descripcionTipoReparto;

	//bi-directional many-to-one association to CatNivelServicio
	@OneToMany(mappedBy="catTipoReparto")
	private List<CatNivelServicio> catNivelServicios;

	public CatTipoReparto() {
	}

	public int getIdCatTipoReparto() {
		return this.idCatTipoReparto;
	}

	public void setIdCatTipoReparto(int idCatTipoReparto) {
		this.idCatTipoReparto = idCatTipoReparto;
	}

	public String getCodigoTipoReparto() {
		return this.codigoTipoReparto;
	}

	public void setCodigoTipoReparto(String codigoTipoReparto) {
		this.codigoTipoReparto = codigoTipoReparto;
	}

	public String getDescripcionTipoReparto() {
		return this.descripcionTipoReparto;
	}

	public void setDescripcionTipoReparto(String descripcionTipoReparto) {
		this.descripcionTipoReparto = descripcionTipoReparto;
	}

	public List<CatNivelServicio> getCatNivelServicios() {
		return this.catNivelServicios;
	}

	public void setCatNivelServicios(List<CatNivelServicio> catNivelServicios) {
		this.catNivelServicios = catNivelServicios;
	}

	public CatNivelServicio addCatNivelServicio(CatNivelServicio catNivelServicio) {
		getCatNivelServicios().add(catNivelServicio);
		catNivelServicio.setCatTipoReparto(this);

		return catNivelServicio;
	}

	public CatNivelServicio removeCatNivelServicio(CatNivelServicio catNivelServicio) {
		getCatNivelServicios().remove(catNivelServicio);
		catNivelServicio.setCatTipoReparto(null);

		return catNivelServicio;
	}

}