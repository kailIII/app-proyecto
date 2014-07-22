package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ingresos")
public class Ingreso extends NamedEntity {

	private static final long serialVersionUID = 1L;

	private String descripcion;
	
	private String abreviatura;
	
	@Transient
	private int activo;
	
	//constructor por defecto
	public Ingreso() {
		
	}

	//Metodos Getters and Setters
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
}