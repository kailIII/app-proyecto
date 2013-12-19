package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "marcas")
public class Marca extends NamedEntity {
	
	private static final long serialVersionUID = 1L;
	
	private int activo;
	
	public Marca() {
		
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

}