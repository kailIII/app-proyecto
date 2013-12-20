package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Clase de Entidad mapeado como modelo de la BD, especificamente
 * de la tabla clasificaciones
 * @author Rodrigo Garcete
 * @since 20/12/2013
 */
@Entity
@Table(name = "clasificaciones")
public class Clasificacion extends NamedEntity {

	private static final long serialVersionUID = 1L;
	
	private int activo;
	
	public Clasificacion(){
		
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
}