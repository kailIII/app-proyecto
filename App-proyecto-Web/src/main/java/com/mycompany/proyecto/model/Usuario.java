package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entidad Usuario, cada registro de la tabla 
 * representa un objeto de este tipo
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
	@NamedQuery(name="Usuario.findById", query="SELECT c FROM Usuario c WHERE c.codigo = :codigo"),
	@NamedQuery(name="Usuario.findByName", query="SELECT c FROM Usuario c WHERE c.nombre LIKE :nombre"),
	@NamedQuery(name="Usuario.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Usuario(c.codigo, c.nombre) FROM Usuario AS c ORDER BY c.codigo"),
	@NamedQuery(name="Usuario.findByAll", query="SELECT c FROM Usuario c ORDER BY c.codigo")
})
public class Usuario extends NamedEntity {

	private static final long serialVersionUID = 1L;
	
	private String login;
	
	private String clave;
	
	private int activo;

	//Constructores por Defecto
	public Usuario() {
		super();
	}
	
	public Usuario(Long codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	//Metodos Getters and Setters
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