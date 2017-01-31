package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PERONA")
	private int idPerona;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	@Column(name="NUM_IDENTIFICACION")
	private String numIdentificacion;

	@Column(name="PRIMER_APELLIDO")
	private String primerApellido;

	@Column(name="PRIMER_NOMBRE")
	private String primerNombre;

	@Column(name="RAZON_SOCIAL")
	private String razonSocial;

	@Column(name="SEGUNDO_APELLIDO")
	private String segundoApellido;

	@Column(name="SEGUNDO_NOMBRE")
	private String segundoNombre;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="persona")
	private List<Envio> envios;

	//bi-directional many-to-one association to Guia
	@OneToMany(mappedBy="persona1")
	private List<Guia> guias1;

	//bi-directional many-to-one association to Guia
	@OneToMany(mappedBy="persona2")
	private List<Guia> guias2;

	//bi-directional many-to-one association to CatTipoIdentificacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_TIPO_IDENTIFICACION_ID_TIPO_IDENTIFICACION")
	private CatTipoIdentificacion catTipoIdentificacion;

	//bi-directional many-to-one association to CatTipoPersona
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_TIPO_PERSONA_ID_TIPO_PERSONA")
	private CatTipoPersona catTipoPersona;

	//bi-directional many-to-one association to Direccion
	@ManyToOne()
	private Direccion direccion;

	//bi-directional many-to-one association to PersonaDirectorio
	@OneToMany(mappedBy="persona")
	private List<PersonaDirectorio> personaDirectorios;

	//bi-directional many-to-one association to Prefactura
	@OneToMany(mappedBy="persona")
	private List<Prefactura> prefacturas;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="persona")
	private List<Usuario> usuarios;

	public Persona() {
	}

	public int getIdPerona() {
		return this.idPerona;
	}

	public void setIdPerona(int idPerona) {
		this.idPerona = idPerona;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNumIdentificacion() {
		return this.numIdentificacion;
	}

	public void setNumIdentificacion(String numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setPersona(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setPersona(null);

		return envio;
	}

	public List<Guia> getGuias1() {
		return this.guias1;
	}

	public void setGuias1(List<Guia> guias1) {
		this.guias1 = guias1;
	}

	public Guia addGuias1(Guia guias1) {
		getGuias1().add(guias1);
		guias1.setPersona1(this);

		return guias1;
	}

	public Guia removeGuias1(Guia guias1) {
		getGuias1().remove(guias1);
		guias1.setPersona1(null);

		return guias1;
	}

	public List<Guia> getGuias2() {
		return this.guias2;
	}

	public void setGuias2(List<Guia> guias2) {
		this.guias2 = guias2;
	}

	public Guia addGuias2(Guia guias2) {
		getGuias2().add(guias2);
		guias2.setPersona2(this);

		return guias2;
	}

	public Guia removeGuias2(Guia guias2) {
		getGuias2().remove(guias2);
		guias2.setPersona2(null);

		return guias2;
	}

	public CatTipoIdentificacion getCatTipoIdentificacion() {
		return this.catTipoIdentificacion;
	}

	public void setCatTipoIdentificacion(CatTipoIdentificacion catTipoIdentificacion) {
		this.catTipoIdentificacion = catTipoIdentificacion;
	}

	public CatTipoPersona getCatTipoPersona() {
		return this.catTipoPersona;
	}

	public void setCatTipoPersona(CatTipoPersona catTipoPersona) {
		this.catTipoPersona = catTipoPersona;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<PersonaDirectorio> getPersonaDirectorios() {
		return this.personaDirectorios;
	}

	public void setPersonaDirectorios(List<PersonaDirectorio> personaDirectorios) {
		this.personaDirectorios = personaDirectorios;
	}

	public PersonaDirectorio addPersonaDirectorio(PersonaDirectorio personaDirectorio) {
		getPersonaDirectorios().add(personaDirectorio);
		personaDirectorio.setPersona(this);

		return personaDirectorio;
	}

	public PersonaDirectorio removePersonaDirectorio(PersonaDirectorio personaDirectorio) {
		getPersonaDirectorios().remove(personaDirectorio);
		personaDirectorio.setPersona(null);

		return personaDirectorio;
	}

	public List<Prefactura> getPrefacturas() {
		return this.prefacturas;
	}

	public void setPrefacturas(List<Prefactura> prefacturas) {
		this.prefacturas = prefacturas;
	}

	public Prefactura addPrefactura(Prefactura prefactura) {
		getPrefacturas().add(prefactura);
		prefactura.setPersona(this);

		return prefactura;
	}

	public Prefactura removePrefactura(Prefactura prefactura) {
		getPrefacturas().remove(prefactura);
		prefactura.setPersona(null);

		return prefactura;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPersona(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPersona(null);

		return usuario;
	}

}