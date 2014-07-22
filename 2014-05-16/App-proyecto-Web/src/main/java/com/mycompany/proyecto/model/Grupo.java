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
@Table(name = "grupos")
@NamedQueries({
	@NamedQuery(name="Grupo.findById", query="SELECT g FROM Grupo g WHERE g.codigo = :codigo"),
	@NamedQuery(name="Grupo.findByName", query="SELECT g FROM Grupo g WHERE g.nombre LIKE :nombre"),
	@NamedQuery(name="Grupo.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Grupo(g.codigo, g.nombre) FROM Grupo AS g ORDER BY g.codigo"),
	@NamedQuery(name="Grupo.findByAll", query="SELECT g FROM Grupo g ORDER BY g.codigo")
})
public class Grupo extends NamedEntity {

	private static final long serialVersionUID = 1L;
	
	private int activo;
	
	//Constructor por defecto
	public Grupo(){
		super();
	}
	
	public Grupo(Long codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	//Metodos Getters and Setters
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	public int getActivo() {
		return activo;
	}
	
}