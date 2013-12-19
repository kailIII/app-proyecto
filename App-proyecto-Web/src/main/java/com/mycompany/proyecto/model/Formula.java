package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "formulas")
public class Formula extends NamedEntity {

	private static final long serialVersionUID = 1L;

	private String descripcion;

	private int activo;

	public Formula() {

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