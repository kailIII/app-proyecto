package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cargos")
public class Cargo extends NamedEntity {

	private static final long serialVersionUID = 1L;
	
	private String descripcion;
	
	private int activo;
	
	public Cargo(){
		
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	public int getActivo() {
		return activo;
	}
	
}