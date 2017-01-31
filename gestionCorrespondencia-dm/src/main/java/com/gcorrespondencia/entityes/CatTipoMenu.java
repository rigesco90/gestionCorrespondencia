package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_tipo_menu database table.
 * 
 */
@Entity
@Table(name="cat_tipo_menu")
@NamedQuery(name="CatTipoMenu.findAll", query="SELECT c FROM CatTipoMenu c")
public class CatTipoMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TIPO_MENU")
	private int idTipoMenu;

	@Column(name="CODIGO_TIPO_MENU")
	private String codigoTipoMenu;

	@Column(name="DESCRIPCION_TIPO_MENU")
	private String descripcionTipoMenu;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to CatMenu
	@OneToMany(mappedBy="catTipoMenu")
	private List<CatMenu> catMenus;

	public CatTipoMenu() {
	}

	public int getIdTipoMenu() {
		return this.idTipoMenu;
	}

	public void setIdTipoMenu(int idTipoMenu) {
		this.idTipoMenu = idTipoMenu;
	}

	public String getCodigoTipoMenu() {
		return this.codigoTipoMenu;
	}

	public void setCodigoTipoMenu(String codigoTipoMenu) {
		this.codigoTipoMenu = codigoTipoMenu;
	}

	public String getDescripcionTipoMenu() {
		return this.descripcionTipoMenu;
	}

	public void setDescripcionTipoMenu(String descripcionTipoMenu) {
		this.descripcionTipoMenu = descripcionTipoMenu;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<CatMenu> getCatMenus() {
		return this.catMenus;
	}

	public void setCatMenus(List<CatMenu> catMenus) {
		this.catMenus = catMenus;
	}

	public CatMenu addCatMenus(CatMenu catMenus) {
		getCatMenus().add(catMenus);
		catMenus.setCatTipoMenu(this);

		return catMenus;
	}

	public CatMenu removeCatMenus(CatMenu catMenus) {
		getCatMenus().remove(catMenus);
		catMenus.setCatTipoMenu(null);

		return catMenus;
	}

}