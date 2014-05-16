package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "conceptos")
public class Concepto extends NamedEntity {

	private static final long serialVersionUID = 1L;
	
	private String abreviatura;
	
	private int activo;
	
	public Concepto() {
		
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