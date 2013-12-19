package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author rodrigo garcete Fecha Creacion:23/11/2013
 * 
 */
@Entity
@Table(name = "paises")
public class Pais extends NamedEntity {

	private static final long serialVersionUID = 1L;

	private String abreviatura;

	private int activo;
	
	

	// Constructor por Defecto
	public Pais() {

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