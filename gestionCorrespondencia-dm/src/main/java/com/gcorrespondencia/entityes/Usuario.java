package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_USUARIO")
	private int idUsuario;

	@Column(name="CODIGO_USUARIO")
	private String codigoUsuario;

	@Column(name="CONTRASENA_USUARIO")
	private String contrasenaUsuario;

	@Column(name="DESCRIPCION_USUARIO")
	private String descripcionUsuario;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to CatMenu
	@OneToMany(mappedBy="usuario")
	private List<CatMenu> catMenus;

	//bi-directional many-to-one association to CatRol
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_ROL_ID_ROL")
	private CatRol catRol;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.LAZY)
	private Persona persona;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCodigoUsuario() {
		return this.codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getContrasenaUsuario() {
		return this.contrasenaUsuario;
	}

	public void setContrasenaUsuario(String contrasenaUsuario) {
		this.contrasenaUsuario = contrasenaUsuario;
	}

	public String getDescripcionUsuario() {
		return this.descripcionUsuario;
	}

	public void setDescripcionUsuario(String descripcionUsuario) {
		this.descripcionUsuario = descripcionUsuario;
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
		catMenus.setUsuario(this);

		return catMenus;
	}

	public CatMenu removeCatMenus(CatMenu catMenus) {
		getCatMenus().remove(catMenus);
		catMenus.setUsuario(null);

		return catMenus;
	}

	public CatRol getCatRol() {
		return this.catRol;
	}

	public void setCatRol(CatRol catRol) {
		this.catRol = catRol;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}