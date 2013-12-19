package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "grupos")
public class Grupo extends NamedEntity {

	private static final long serialVersionUID = 1L;
	
	private int activo;
	
	public Grupo(){
		
	}
	
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	public int getActivo() {
		return activo;
	}
	
}