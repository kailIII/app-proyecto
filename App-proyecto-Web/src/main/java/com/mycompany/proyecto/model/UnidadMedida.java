package com.mycompany.proyecto.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author rodrigo garcete Fecha 
 * Creacion:23/11/2013
 */
@Entity
@Table(name = "unidades_medidas")
public class UnidadMedida extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Size(min = 3, max = 80)
	@NotNull
	private String nombre;

	@NotNull
	private String abreviatura;

	private int activo;

	//Constructor por defecto
	public UnidadMedida() {

	}

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
	
//	@Override
//    public String toString() {
//        return new ToStringCreator(this)
//
//                .append("id", this.getCodigo())
//                .append("new", this.isNew())
//                .append("nombre", this.getNombre())
//                .append("Abreviatura", this.abreviatura)
//                .append("activo", this.activo)
//                .toString();
//    }


}