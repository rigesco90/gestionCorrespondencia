package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the vehiculo database table.
 * 
 */
@Entity
@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_VEHICULO")
	private int idVehiculo;

	@Column(name="CODIGO_VEHICULO")
	private String codigoVehiculo;

	@Column(name="DESCRIPCION_VEHICULO")
	private String descripcionVehiculo;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	private String placas;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="vehiculo")
	private List<Envio> envios;

	public Vehiculo() {
	}

	public int getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getCodigoVehiculo() {
		return this.codigoVehiculo;
	}

	public void setCodigoVehiculo(String codigoVehiculo) {
		this.codigoVehiculo = codigoVehiculo;
	}

	public String getDescripcionVehiculo() {
		return this.descripcionVehiculo;
	}

	public void setDescripcionVehiculo(String descripcionVehiculo) {
		this.descripcionVehiculo = descripcionVehiculo;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getPlacas() {
		return this.placas;
	}

	public void setPlacas(String placas) {
		this.placas = placas;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setVehiculo(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setVehiculo(null);

		return envio;
	}

}