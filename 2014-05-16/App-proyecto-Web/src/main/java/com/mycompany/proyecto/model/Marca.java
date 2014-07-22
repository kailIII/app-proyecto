package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * 
 * @author Rodrigo Garcete
 * @since 15/12/2013
 */
@Entity
@Table(name = "marcas")
@NamedQueries({
	@NamedQuery(name="Marca.findById", query="SELECT m FROM Marca m WHERE m.codigo = :codigo"),
	@NamedQuery(name="Marca.findByName", query="SELECT m FROM Marca m WHERE m.nombre LIKE :nombre"),
	@NamedQuery(name="Marca.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Marca(m.codigo, m.nombre) FROM Marca AS m ORDER BY m.codigo"),
	@NamedQuery(name="Marca.findByAll", query="SELECT m FROM Marca m ORDER BY m.codigo")
})
public class Marca extends NamedEntity {
	
	private static final long serialVersionUID = 1L;
	
	private int activo;
	
	//Constructor por Defecto
	public Marca() {
		super();
	}
	
	public Marca(Long codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}

	//Getters and Setters
	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

}