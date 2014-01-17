package com.mycompany.proyecto.model;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@MappedSuperclass
public class Persona extends NamedEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	protected String apellido;
	
	private String direccion;
	
	private String barrio;
		
	private int activo;
	
	//Constructor por Defecto
	public Persona(){
		super();
	}
	
	//Metodos Getters and Setters
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
}