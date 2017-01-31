package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_nivel_servicio database table.
 * 
 */
@Entity
@Table(name="cat_nivel_servicio")
@NamedQuery(name="CatNivelServicio.findAll", query="SELECT c FROM CatNivelServicio c")
public class CatNivelServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CAT_NIVEL_SERVICIO")
	private int idCatNivelServicio;

	@Column(name="CODIGO_NIVEL_SERVICIO")
	private String codigoNivelServicio;

	@Column(name="DESCRIPCION_NIVEL_SERVICIO")
	private String descripcionNivelServicio;

	@Column(name="`FECHA CREACION`")
	private Timestamp fecha_creacion;

	private Double precio = null;

	private int tiempo;

	//bi-directional many-to-one association to CatMunicipio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_MUNICIPIO_ID_MUNICIPIO")
	private CatMunicipio catMunicipio;

	//bi-directional many-to-one association to CatServicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_SERVICIOS_ID_CAT_SERVICIOS")
	private CatServicio catServicio;

	//bi-directional many-to-one association to Guia
	@OneToMany(mappedBy="catNivelServicio")
	private List<Guia> guias;

	//bi-directional many-to-one association to CatRangoPeso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RANGO_PESO_ID_RANGO_PESO")
	private CatRangoPeso catRangoPeso;

	//bi-directional many-to-one association to CatTipoReparto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_TIPO_REPARTO_ID_CAT_TIPO_REPARTO")
	private CatTipoReparto catTipoReparto;

	public CatNivelServicio() {
	}

	public int getIdCatNivelServicio() {
		return this.idCatNivelServicio;
	}

	public void setIdCatNivelServicio(int idCatNivelServicio) {
		this.idCatNivelServicio = idCatNivelServicio;
	}

	public String getCodigoNivelServicio() {
		return this.codigoNivelServicio;
	}

	public void setCodigoNivelServicio(String codigoNivelServicio) {
		this.codigoNivelServicio = codigoNivelServicio;
	}

	public String getDescripcionNivelServicio() {
		return this.descripcionNivelServicio;
	}

	public void setDescripcionNivelServicio(String descripcionNivelServicio) {
		this.descripcionNivelServicio = descripcionNivelServicio;
	}

	public Timestamp getFecha_creacion() {
		return this.fecha_creacion;
	}

	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public CatMunicipio getCatMunicipio() {
		return this.catMunicipio;
	}

	public void setCatMunicipio(CatMunicipio catMunicipio) {
		this.catMunicipio = catMunicipio;
	}

	public CatServicio getCatServicio() {
		return this.catServicio;
	}

	public void setCatServicio(CatServicio catServicio) {
		this.catServicio = catServicio;
	}

	public List<Guia> getGuias() {
		return this.guias;
	}

	public void setGuias(List<Guia> guias) {
		this.guias = guias;
	}

	public Guia addGuia(Guia guia) {
		getGuias().add(guia);
		guia.setCatNivelServicio(this);

		return guia;
	}

	public Guia removeGuia(Guia guia) {
		getGuias().remove(guia);
		guia.setCatNivelServicio(null);

		return guia;
	}

	public CatRangoPeso getCatRangoPeso() {
		return this.catRangoPeso;
	}

	public void setCatRangoPeso(CatRangoPeso catRangoPeso) {
		this.catRangoPeso = catRangoPeso;
	}

	public CatTipoReparto getCatTipoReparto() {
		return this.catTipoReparto;
	}

	public void setCatTipoReparto(CatTipoReparto catTipoReparto) {
		this.catTipoReparto = catTipoReparto;
	}

}