package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "tipo_personas")
public class TipoPersona extends NamedEntity {

	private static final long serialVersionUID = 1L;
	
	private int activo;
	
	public TipoPersona() {
		
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

}