package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_barrio database table.
 * 
 */
@Entity
@Table(name="cat_barrio")
@NamedQuery(name="CatBarrio.findAll", query="SELECT c FROM CatBarrio c")
public class CatBarrio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_BARRIO")
	private int idBarrio;

	@Column(name="CODIGO_BARRIO")
	private String codigoBarrio;

	@Column(name="DESCRIPCION_BARRIO")
	private String descripcionBarrio;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to CatMunicipio
	//@ManyToOne(fetch=FetchType.LAZY)
	@ManyToOne(optional=false)
	@JoinColumn(name="CAT_MUNICIPIO_ID_MUNICIPIO")
	private CatMunicipio catMunicipio;

	//bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy="catBarrio")
	private List<Direccion> direccions;

	//bi-directional many-to-one association to ZonaBarrio
	@OneToMany(mappedBy="catBarrio")
	private List<ZonaBarrio> zonaBarrios;

	public CatBarrio() {
	}

	public int getIdBarrio() {
		return this.idBarrio;
	}

	public void setIdBarrio(int idBarrio) {
		this.idBarrio = idBarrio;
	}

	public String getCodigoBarrio() {
		return this.codigoBarrio;
	}

	public void setCodigoBarrio(String codigoBarrio) {
		this.codigoBarrio = codigoBarrio;
	}

	public String getDescripcionBarrio() {
		return this.descripcionBarrio;
	}

	public void setDescripcionBarrio(String descripcionBarrio) {
		this.descripcionBarrio = descripcionBarrio;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public CatMunicipio getCatMunicipio() {
		return this.catMunicipio;
	}

	public void setCatMunicipio(CatMunicipio catMunicipio) {
		this.catMunicipio = catMunicipio;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setCatBarrio(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setCatBarrio(null);

		return direccion;
	}

	public List<ZonaBarrio> getZonaBarrios() {
		return this.zonaBarrios;
	}

	public void setZonaBarrios(List<ZonaBarrio> zonaBarrios) {
		this.zonaBarrios = zonaBarrios;
	}

	public ZonaBarrio addZonaBarrio(ZonaBarrio zonaBarrio) {
		getZonaBarrios().add(zonaBarrio);
		zonaBarrio.setCatBarrio(this);

		return zonaBarrio;
	}

	public ZonaBarrio removeZonaBarrio(ZonaBarrio zonaBarrio) {
		getZonaBarrios().remove(zonaBarrio);
		zonaBarrio.setCatBarrio(null);

		return zonaBarrio;
	}

}