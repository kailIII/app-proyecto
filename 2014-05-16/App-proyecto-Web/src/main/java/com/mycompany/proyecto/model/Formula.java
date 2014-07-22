package com.mycompany.proyecto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * Entidad Formula
 * 
 * @author Rodrigo Garcete
 * @since 05/01/2014
 * 
 */
@Entity
@Table(name = "formulas")
@NamedQueries({
	@NamedQuery(name="Formula.findById", query="SELECT c FROM Formula c WHERE c.codigo = :codigo"),
	@NamedQuery(name="Formula.findByName", query="SELECT c FROM Formula c WHERE c.nombre LIKE :nombre"),
	@NamedQuery(name="Formula.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Formula(c.codigo, c.nombre) FROM Formula AS c ORDER BY c.codigo"),
	@NamedQuery(name="Formula.findByAll", query="SELECT c FROM Formula c ORDER BY c.codigo")
})
public class Formula extends NamedEntity {

	private static final long serialVersionUID = 1L;

	private String descripcion;

	private int activo;
	
	/**
	 * MappedBy: informamos el nombre de la variable de instancia,
	 * que va a indicar a quien el One pertenece
	 * TargetEntity: informa cual es la asociacion entre las entidades
	 * FetchType.Lazy: Este tipo fue escogido por performance
	 * cascade: ALL para permitir alteraciones en todos los relacionamientos
	 */
	@OneToMany(mappedBy = "formula", targetEntity = FormulaDetalle.class, 
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<FormulaDetalle> fdetalle;

	//Constructores por Defecto
	public Formula() {
		super();
	}
	
	public Formula(Long codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	//Metodos Getters and Setters
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	public void setFdetalle(List<FormulaDetalle> fdetalle) {
		this.fdetalle = fdetalle;
	}
	
	public List<FormulaDetalle> getFdetalle() {
		return fdetalle;
	}

}