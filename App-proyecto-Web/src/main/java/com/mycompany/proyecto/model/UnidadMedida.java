package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * Entidad que representa una unidad de medida
 * @author Rodrigo Garcete 
 * @since 23/11/2013
 */
@Entity
@Table(name = "unidades_medidas")
public class UnidadMedida extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 3, max = 80)
	private String nombre;

	@NotNull
	@Size(min = 1, max = 3)
	private String abreviatura;

	private int activo;

	//Constructor por defecto
	public UnidadMedida() {
		super();
	}

	//Metodos Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
}