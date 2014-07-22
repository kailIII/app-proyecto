package com.mycompany.proyecto.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Un simple POJO con una propiedad codigo.
 * Se utiliza como clase base para los objetos que necesiten 
 * esta propiedad
 * @author Rodrigo Garcete
 * Fecha de Creacion:21-11-2013
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long codigo;
	 
	//Constructor por Defecto
	public BaseEntity() {
		
	}
	
	//Metodos Getters and Setters
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	//Metodo Equals de Object
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;

        return true;
    }
	
	//Metodo HasCode de Object
	@Override
	public int hashCode() {
		return codigo != null ? codigo.hashCode() :0;
	}

}