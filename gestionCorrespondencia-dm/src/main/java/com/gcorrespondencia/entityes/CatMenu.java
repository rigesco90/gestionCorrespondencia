package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_menu database table.
 * 
 */
@Entity
@Table(name="cat_menu")
@NamedQuery(name="CatMenu.findAll", query="SELECT c FROM CatMenu c")
public class CatMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CAT_MENU")
	private int idCatMenu;

	@Column(name="COD_CAT_MENU")
	private String codCatMenu;

	@Column(name="DESCRIPCION_CAT_MENU")
	private String descripcionCatMenu;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	private String url;

	//bi-directional many-to-one association to CatEstado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_ESTADO_ID_ESTADO")
	private CatEstado catEstado;

	//bi-directional many-to-one association to CatMenu
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_MENU_ID_CAT_MENU")
	private CatMenu catMenu;

	//bi-directional many-to-one association to CatMenu
	@OneToMany(mappedBy="catMenu")
	private List<CatMenu> catMenus;

	//bi-directional many-to-one association to CatTipoMenu
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_TIPO_MENU_ID_TIPO_MENU")
	private CatTipoMenu catTipoMenu;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;

	public CatMenu() {
	}

	public int getIdCatMenu() {
		return this.idCatMenu;
	}

	public void setIdCatMenu(int idCatMenu) {
		this.idCatMenu = idCatMenu;
	}

	public String getCodCatMenu() {
		return this.codCatMenu;
	}

	public void setCodCatMenu(String codCatMenu) {
		this.codCatMenu = codCatMenu;
	}

	public String getDescripcionCatMenu() {
		return this.descripcionCatMenu;
	}

	public void setDescripcionCatMenu(String descripcionCatMenu) {
		this.descripcionCatMenu = descripcionCatMenu;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public CatEstado getCatEstado() {
		return this.catEstado;
	}

	public void setCatEstado(CatEstado catEstado) {
		this.catEstado = catEstado;
	}

	public CatMenu getCatMenu() {
		return this.catMenu;
	}

	public void setCatMenu(CatMenu catMenu) {
		this.catMenu = catMenu;
	}

	public List<CatMenu> getCatMenus() {
		return this.catMenus;
	}

	public void setCatMenus(List<CatMenu> catMenus) {
		this.catMenus = catMenus;
	}

	public CatMenu addCatMenus(CatMenu catMenus) {
		getCatMenus().add(catMenus);
		catMenus.setCatMenu(this);

		return catMenus;
	}

	public CatMenu removeCatMenus(CatMenu catMenus) {
		getCatMenus().remove(catMenus);
		catMenus.setCatMenu(null);

		return catMenus;
	}

	public CatTipoMenu getCatTipoMenu() {
		return this.catTipoMenu;
	}

	public void setCatTipoMenu(CatTipoMenu catTipoMenu) {
		this.catTipoMenu = catTipoMenu;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}