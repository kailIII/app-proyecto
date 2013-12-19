package com.mycompany.proyecto.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "clientes")
public class Cliente extends Persona {

	private static final long serialVersionUID = 1L;
	
	//private Set<TipoPersona> tipoPersona;
	
	private String ci;
	
	private String ruc;
	
	private String dv;
	
	private String rucdv;
	
	private String telefono;
	
	private String telefono2;
	
	private String celular;
	
	private String celular2;
	
	private String email1;
	
	private String email2;
	
	private String skype;
	
	private String fax;
	
	private String web;
	
//	private Set<Ciudad> ciudades;
//	
//	private Set<Departamento> departamentos;
//	
//	private Set<Pais> paises;
	
	private String obs;
	
	public Cliente() {
		
	}
	
	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
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

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

//	public Set<Ciudad> getCiudades() {
//		return ciudades;
//	}
//
//	public void setCiudades(Set<Ciudad> ciudades) {
//		this.ciudades = ciudades;
//	}
//
//	public Set<Departamento> getDepartamentos() {
//		return departamentos;
//	}
//
//	public void setDepartamentos(Set<Departamento> departamentos) {
//		this.departamentos = departamentos;
//	}
//
//	public Set<Pais> getPaises() {
//		return paises;
//	}
//
//	public void setPaises(Set<Pais> paises) {
//		this.paises = paises;
//	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

//	public Set<TipoPersona> getTipoPersona() {
//		return tipoPersona;
//	}
//
//	public void setTipoPersona(Set<TipoPersona> tipoPersona) {
//		this.tipoPersona = tipoPersona;
//	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDv() {
		return dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
	}

	public String getRucdv() {
		return rucdv;
	}

	public void setRucdv(String rucdv) {
		this.rucdv = rucdv;
	}

}