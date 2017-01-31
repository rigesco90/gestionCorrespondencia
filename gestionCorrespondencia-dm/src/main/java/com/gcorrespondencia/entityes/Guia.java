package com.gcorrespondencia.entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the guia database table.
 * 
 */
@Entity
@NamedQuery(name="Guia.findAll", query="SELECT g FROM Guia g")
public class Guia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_GUIA")
	private int idGuia;

	@Column(name="CODIGO_BARRAS")
	private String codigoBarras;

	@Column(name="CODIGO_GUIA")
	private String codigoGuia;

	@Column(name="DESCRIPCION_ENVIO")
	private String descripcionEnvio;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name="`PESO REAL`")
	private int peso_real;

	private int unidades;

	@Column(name="`VALOR DECLARADO`")
	private double valor_declarado;

	@Column(name="`VOLUMEN REAL`")
	private int volumen_real;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="guia")
	private List<Envio> envios;

	//bi-directional many-to-one association to CatNivelServicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CAT_NIVEL_SERVICIO_ID_CAT_NIVEL_SERVICIO")
	private CatNivelServicio catNivelServicio;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PERSONA_ID_PERONA")
	private Persona persona1;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PERSONA_ID_PERONA1")
	private Persona persona2;

	//bi-directional many-to-one association to GuiaEnvio
	@OneToMany(mappedBy="guia")
	private List<GuiaEnvio> guiaEnvios;

	//bi-directional many-to-one association to GuiaPlanilla
	@OneToMany(mappedBy="guia")
	private List<GuiaPlanilla> guiaPlanillas;

	//bi-directional many-to-one association to VitacoraGuia
	@OneToMany(mappedBy="guia")
	private List<VitacoraGuia> vitacoraGuias;

	public Guia() {
	}

	public int getIdGuia() {
		return this.idGuia;
	}

	public void setIdGuia(int idGuia) {
		this.idGuia = idGuia;
	}

	public String getCodigoBarras() {
		return this.codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getCodigoGuia() {
		return this.codigoGuia;
	}

	public void setCodigoGuia(String codigoGuia) {
		this.codigoGuia = codigoGuia;
	}

	public String getDescripcionEnvio() {
		return this.descripcionEnvio;
	}

	public void setDescripcionEnvio(String descripcionEnvio) {
		this.descripcionEnvio = descripcionEnvio;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getPeso_real() {
		return this.peso_real;
	}

	public void setPeso_real(int peso_real) {
		this.peso_real = peso_real;
	}

	public int getUnidades() {
		return this.unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public double getValor_declarado() {
		return this.valor_declarado;
	}

	public void setValor_declarado(double valor_declarado) {
		this.valor_declarado = valor_declarado;
	}

	public int getVolumen_real() {
		return this.volumen_real;
	}

	public void setVolumen_real(int volumen_real) {
		this.volumen_real = volumen_real;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setGuia(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setGuia(null);

		return envio;
	}

	public CatNivelServicio getCatNivelServicio() {
		return this.catNivelServicio;
	}

	public void setCatNivelServicio(CatNivelServicio catNivelServicio) {
		this.catNivelServicio = catNivelServicio;
	}

	public Persona getPersona1() {
		return this.persona1;
	}

	public void setPersona1(Persona persona1) {
		this.persona1 = persona1;
	}

	public Persona getPersona2() {
		return this.persona2;
	}

	public void setPersona2(Persona persona2) {
		this.persona2 = persona2;
	}

	public List<GuiaEnvio> getGuiaEnvios() {
		return this.guiaEnvios;
	}

	public void setGuiaEnvios(List<GuiaEnvio> guiaEnvios) {
		this.guiaEnvios = guiaEnvios;
	}

	public GuiaEnvio addGuiaEnvio(GuiaEnvio guiaEnvio) {
		getGuiaEnvios().add(guiaEnvio);
		guiaEnvio.setGuia(this);

		return guiaEnvio;
	}

	public GuiaEnvio removeGuiaEnvio(GuiaEnvio guiaEnvio) {
		getGuiaEnvios().remove(guiaEnvio);
		guiaEnvio.setGuia(null);

		return guiaEnvio;
	}

	public List<GuiaPlanilla> getGuiaPlanillas() {
		return this.guiaPlanillas;
	}

	public void setGuiaPlanillas(List<GuiaPlanilla> guiaPlanillas) {
		this.guiaPlanillas = guiaPlanillas;
	}

	public GuiaPlanilla addGuiaPlanilla(GuiaPlanilla guiaPlanilla) {
		getGuiaPlanillas().add(guiaPlanilla);
		guiaPlanilla.setGuia(this);

		return guiaPlanilla;
	}

	public GuiaPlanilla removeGuiaPlanilla(GuiaPlanilla guiaPlanilla) {
		getGuiaPlanillas().remove(guiaPlanilla);
		guiaPlanilla.setGuia(null);

		return guiaPlanilla;
	}

	public List<VitacoraGuia> getVitacoraGuias() {
		return this.vitacoraGuias;
	}

	public void setVitacoraGuias(List<VitacoraGuia> vitacoraGuias) {
		this.vitacoraGuias = vitacoraGuias;
	}

	public VitacoraGuia addVitacoraGuia(VitacoraGuia vitacoraGuia) {
		getVitacoraGuias().add(vitacoraGuia);
		vitacoraGuia.setGuia(this);

		return vitacoraGuia;
	}

	public VitacoraGuia removeVitacoraGuia(VitacoraGuia vitacoraGuia) {
		getVitacoraGuias().remove(vitacoraGuia);
		vitacoraGuia.setGuia(null);

		return vitacoraGuia;
	}

}