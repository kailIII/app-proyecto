package com.mycompany.proyecto.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * 
 * @author Rodrigo Garcete 
 * @since 21/11/2013
 */
@Entity
@Table(name = "proveedores")
@NamedQueries({
	@NamedQuery(name="Proveedor.findById", query="SELECT p FROM Proveedor p WHERE p.codigo = :codigo"),
	@NamedQuery(name="Proveedor.findByName", query="SELECT p FROM Proveedor p WHERE p.nombre LIKE :nombre"),
	@NamedQuery(name="Proveedor.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Proveedor(p.codigo, p.nombre) FROM Proveedor AS p ORDER BY p.codigo"),
	@NamedQuery(name="Proveedor.findByAll", query="SELECT p FROM Proveedor p ORDER BY p.codigo")
})
public class Proveedor extends Persona {

	private static final long serialVersionUID = 1L;

	private String ci;

	private String ruc;
	
	@Column(name = "codigo_postal")
	private String codigoPostal;

	private String representante;

	private String direccion2;
	
	@OneToOne //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ciudad_id")
	@Basic(optional=false)
	private Ciudad ciudad;
	
	private String telefono;

	private String telefono2;

	private String celular;

	private String celular2;

	//Constructor por Defecto
	public Proveedor() {
		super();
	}
	
	public Proveedor(Long codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	//Metodos Getters and Setters
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
	
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}
	
	public String getDireccion2() {
		return direccion2;
	}

}