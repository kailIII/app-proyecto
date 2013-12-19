package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "prevision")
public class Prevision extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	private int activo;
	
	public Prevision() {
		
	}
	
}