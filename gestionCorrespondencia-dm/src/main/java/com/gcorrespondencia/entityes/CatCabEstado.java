package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_cab_estado database table.
 * 
 */
@Entity
@Table(name="cat_cab_estado")
@NamedQuery(name="CatCabEstado.findAll", query="SELECT c FROM CatCabEstado c")
public class CatCabEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDCAT_CAB_ESTADO")
	private int idcatCabEstado;

	@Column(name="DESCRIPCION_CAB_ESTADO")
	private String descripcionCabEstado;

	//bi-directional many-to-one association to CatEstado
	@OneToMany(mappedBy="catCabEstado")
	private List<CatEstado> catEstados;

	public CatCabEstado() {
	}

	public int getIdcatCabEstado() {
		return this.idcatCabEstado;
	}

	public void setIdcatCabEstado(int idcatCabEstado) {
		this.idcatCabEstado = idcatCabEstado;
	}

	public String getDescripcionCabEstado() {
		return this.descripcionCabEstado;
	}

	public void setDescripcionCabEstado(String descripcionCabEstado) {
		this.descripcionCabEstado = descripcionCabEstado;
	}

	public List<CatEstado> getCatEstados() {
		return this.catEstados;
	}

	public void setCatEstados(List<CatEstado> catEstados) {
		this.catEstados = catEstados;
	}

	public CatEstado addCatEstado(CatEstado catEstado) {
		getCatEstados().add(catEstado);
		catEstado.setCatCabEstado(this);

		return catEstado;
	}

	public CatEstado removeCatEstado(CatEstado catEstado) {
		getCatEstados().remove(catEstado);
		catEstado.setCatCabEstado(null);

		return catEstado;
	}

}