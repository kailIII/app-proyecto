package com.mycompany.proyecto.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "clientes")
@NamedQueries({
	@NamedQuery(name="Cliente.findById", query="SELECT i FROM Cliente i WHERE i.codigo = :codigo"),
	@NamedQuery(name="Cliente.findByName", query="SELECT i FROM Cliente i WHERE i.nombre LIKE :nombre"),
	@NamedQuery(name="Cliente.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Cliente(i.codigo, i.nombre) "
			+ "FROM Cliente AS i ORDER BY i.codigo"),
	@NamedQuery(name="Cliente.findByAll", query="SELECT NEW com.mycompany.proyecto.model.Cliente(i.codigo, i.nombre, "
			+ "i.apellido, i.telefono, i.celular, i.email) FROM Cliente AS i ORDER BY i.codigo")
})
public class Cliente extends Persona {

	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name="tp_id")
	@Basic(optional=false)
	@NotNull(message = "Tipo Persona es un campo obligatorio") 
	private TipoPersona tipoPersona;
	
	private String ci;
	
	private String ruc;
	
	private String dv;
	
	private String rucdv;
	
	private String telefono;
	
	private String telefono2;
	
	private String celular;
	
	private String celular2;
	
	private String email;
	
	private String email2;
	
	private String skype;
	
	private String fax;
	
	private String web;
	
	@ManyToOne
	@JoinColumn(name = "ciudad_id")
	@Basic(optional=false)
	@NotNull(message = "Ciudad es un campo obligatorio")
	private Ciudad ciudad;
	
	private String obs;
	
	//Constructores por Defecto
	public Cliente() {
		super();
		this.tipoPersona = new TipoPersona();
		this.ciudad = new Ciudad();
	}
	
	public Cliente(Long codigo, String nombre, String apellido, 
			String telefono, String celular, String email) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.celular = celular;
		this.email = email;
	}
	
	public Cliente(Long codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	//Metodos Getters and Setters
	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return email;
	}

	public void setEmail1(String email) {
		this.email = email;
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
	
	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(TipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

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