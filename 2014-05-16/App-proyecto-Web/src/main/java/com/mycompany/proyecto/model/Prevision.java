package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "previsiones")
public class Prevision extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Transient
	private int activo;
	
	//Constructor por defecto
	public Prevision() {
		
	}
	
	//Getters and Setters
	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
}