package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entidad Ciudad que hace referencia a la tabla ciudades en 
 * el modelo de Base de Datos
 * @author Rodrigo Garcete
 * @since 20/12/2013
 *
 */
@Entity
@Table(name = "ciudades")
public class Ciudad extends NamedEntity {

	private static final long serialVersionUID = 1L;

	private String abreviatura;

	private int activo;

	@ManyToOne
	@JoinColumn(name="departamento_id")
	@NotNull
	private Departamento departamento;

	@ManyToOne 
	@JoinColumn(name="pais_id")
	@NotNull
	private Pais pais;

	// Constructor por Defecto
	public Ciudad() {
		this.abreviatura = "";
		this.activo = 1;
		this.departamento = new Departamento();
		this.pais = new Pais();
	}
	
	//Metodos de Obtencion y establecimientos
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}