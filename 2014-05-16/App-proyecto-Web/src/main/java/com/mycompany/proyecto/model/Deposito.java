package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Clase de Entidad, cada objeto representa un registro 
 * de la tabla correspondiente
 * @author Rodrigo Garcete
 * @since 23/12/2013
 * Se utilizo JPA Proyections	
 */
@Entity
@Table(name = "depositos")
@NamedQueries({
	@NamedQuery(name="Deposito.findById", query="SELECT i FROM Deposito i WHERE i.codigo = :codigo"),
	@NamedQuery(name="Deposito.findByName", query="SELECT i FROM Deposito i WHERE i.nombre LIKE :nombre"),
	@NamedQuery(name="Deposito.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Deposito(i.codigo, i.nombre) FROM Deposito AS i ORDER BY i.codigo"),
	@NamedQuery(name="Deposito.findByAll", query="SELECT i FROM Deposito i ORDER BY i.codigo")
})
public class Deposito extends NamedEntity {

	private static final long serialVersionUID = 1L;

	private int activo;

	//Constructor por Defecto
	public Deposito() {
		super();
	}
	
	public Deposito(Long codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}

	//Metodos Getters and Setters
	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

}