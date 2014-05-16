package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name = "operaciones")
public class Operacion extends NamedEntity {

	private static final long serialVersionUID = 1L;

	private String abreviatura;
	
	private String descripcion;
	
	@Transient
	private int activo;
	
	//Constructor por Defecto
	public Operacion() {
	
	}

	//Getters and Setters
	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}	

}