package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_zona database table.
 * 
 */
@Entity
@Table(name="cat_zona")
@NamedQuery(name="CatZona.findAll", query="SELECT c FROM CatZona c")
public class CatZona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ZONA")
	private int idZona;

	@Column(name="CODIGO_ZONA")
	private String codigoZona;

	@Column(name="DESCRIPCION_ZONA")
	private String descripcionZona;

	@Column(name="`FECHA CREACION`")
	private Timestamp fecha_creacion;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="catZona")
	private List<Envio> envios;

	//bi-directional many-to-one association to ZonaBarrio
	@OneToMany(mappedBy="catZona")
	private List<ZonaBarrio> zonaBarrios;

	public CatZona() {
	}

	public int getIdZona() {
		return this.idZona;
	}

	public void setIdZona(int idZona) {
		this.idZona = idZona;
	}

	public String getCodigoZona() {
		return this.codigoZona;
	}

	public void setCodigoZona(String codigoZona) {
		this.codigoZona = codigoZona;
	}

	public String getDescripcionZona() {
		return this.descripcionZona;
	}

	public void setDescripcionZona(String descripcionZona) {
		this.descripcionZona = descripcionZona;
	}

	public Timestamp getFecha_creacion() {
		return this.fecha_creacion;
	}

	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setCatZona(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setCatZona(null);

		return envio;
	}

	public List<ZonaBarrio> getZonaBarrios() {
		return this.zonaBarrios;
	}

	public void setZonaBarrios(List<ZonaBarrio> zonaBarrios) {
		this.zonaBarrios = zonaBarrios;
	}

	public ZonaBarrio addZonaBarrio(ZonaBarrio zonaBarrio) {
		getZonaBarrios().add(zonaBarrio);
		zonaBarrio.setCatZona(this);

		return zonaBarrio;
	}

	public ZonaBarrio removeZonaBarrio(ZonaBarrio zonaBarrio) {
		getZonaBarrios().remove(zonaBarrio);
		zonaBarrio.setCatZona(null);

		return zonaBarrio;
	}

}