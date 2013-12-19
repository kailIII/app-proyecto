package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Entity
@Table(name = "usuarios")
public class Usuario extends NamedEntity {

	private static final long serialVersionUID = 1L;
	
	private String login;
	
	private String clave;
	
	private int activo;

	public Usuario() {
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
}