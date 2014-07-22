package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "estados_civiles")
public class EstadoCivil extends NamedEntity {

	private static final long serialVersionUID = 1L;

	private String descripcion;
	
	@Transient
	private int activo;
	
	public EstadoCivil() {
		
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