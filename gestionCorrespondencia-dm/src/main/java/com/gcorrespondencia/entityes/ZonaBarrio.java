package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the zona_barrio database table.
 * 
 */
@Entity
@Table(name="zona_barrio")
@NamedQuery(name="ZonaBarrio.findAll", query="SELECT z FROM ZonaBarrio z")
public class ZonaBarrio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ZONA_BARRIO")
	private int idZonaBarrio;

	@Column(name="CODIGO_ZONA_BARRIO")
	private String codigoZonaBarrio;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to CatBarrio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_BARRIO_ID_BARRIO")
	private CatBarrio catBarrio;

	//bi-directional many-to-one association to CatZona
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_RUTA_ID_CAT_RUTA")
	private CatZona catZona;

	public ZonaBarrio() {
	}

	public int getIdZonaBarrio() {
		return this.idZonaBarrio;
	}

	public void setIdZonaBarrio(int idZonaBarrio) {
		this.idZonaBarrio = idZonaBarrio;
	}

	public String getCodigoZonaBarrio() {
		return this.codigoZonaBarrio;
	}

	public void setCodigoZonaBarrio(String codigoZonaBarrio) {
		this.codigoZonaBarrio = codigoZonaBarrio;
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

	public CatZona getCatZona() {
		return this.catZona;
	}

	public void setCatZona(CatZona catZona) {
		this.catZona = catZona;
	}

}