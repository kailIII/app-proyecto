package com.mycompany.proyecto.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * Entidad Departamento, cada objeto representa un registro de la respectiva tabla
 * @author Rodrigo Garcete 
 * @since 23/11/2013
 * Se ha utilizado JPA Proyections para optimizar la consulta
 */
@Entity
@Table(name = "departamentos")
@NamedQueries({
	@NamedQuery(name="Departamento.findById", query="SELECT d FROM Departamento d WHERE d.codigo = :codigo"),
	@NamedQuery(name="Departamento.findByName", query="SELECT d FROM Departamento d WHERE d.nombre LIKE :nombre"),
	@NamedQuery(name="Departamento.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Departamento(d.codigo, d.nombre) FROM Departamento AS d ORDER BY d.codigo"),
	@NamedQuery(name="Departamento.findByAll", query="SELECT d FROM Departamento d ORDER BY d.codigo")
})
public class Departamento extends NamedEntity {

	private static final long serialVersionUID = 1L;

	private String abreviatura;

	@ManyToOne
	@JoinColumn(name = "pais_id_dep")
	@Basic(optional = false)
	private Pais pais;

	private int activo;

	// Constructor por Defecto
	public Departamento() {
		super();
		this.pais = new Pais();
	}

	public Departamento(Long codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	//Metodos Getters and Setters
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