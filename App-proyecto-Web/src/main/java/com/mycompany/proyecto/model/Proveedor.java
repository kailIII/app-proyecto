package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author rodrigo garcete Fecha Creacion:21-11-2013
 */
@Entity
@Table(name = "proveedores")
public class Proveedor extends Persona implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String ci;

	private String ruc;

	private String representante;

	@ManyToOne //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ciudad_id")
	@NotNull
	private Ciudad ciudad;
	
	private String telefono;

	private String telefono2;

	private String celular;

	private String celular2;

	//Constructor
	public Proveedor() {

	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCelular2() {
		return celular2;
	}

	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}

}