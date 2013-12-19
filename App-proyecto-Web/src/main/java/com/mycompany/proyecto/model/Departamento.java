package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author rodrigo garcete 
 * Fecha de Creacion:23/11/2013
 * 
 */
@Entity
@Table(name = "departamentos")
public class Departamento extends NamedEntity {

	private static final long serialVersionUID = 1L;

	private String abreviatura;

	@ManyToOne
	@JoinColumn(name = "pais_id_dep")
	@NotNull
	private Pais pais;

	private int activo;

	// Constructor por Defecto
	public Departamento() {

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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}