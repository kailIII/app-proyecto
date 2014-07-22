package com.mycompany.proyecto.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
/**
 * Entidad FormulaDetalle 
 * @author Rodrigo Garcete
 * @since 15/01/2013
 *
 */
@Table(name = "formula_detalles")
@Entity
public class FormulaDetalle extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "formular_id") //, insertable= false, updatable=false
	@NotNull
	private Formula formula;
	
	@ManyToOne
	@JoinColumn(name = "producto_id") //, insertable= false, updatable=false
	@Basic(optional=false)
	private Producto producto;
	
	private Double cantidad;
	
	/**
	 * Utilizado en la Vista, para el paso de parametros con la funcion
	 * Ajax de JQuery, especificamente retorna el codigo del insumo
	 */
	@Transient
	private Long id;
	
	//Constructor por Defecto
	public FormulaDetalle() {
		super();
		this.formula = new Formula();
		this.producto = new Producto();
	}

	//Getters and Setters
	public Formula getFormula() {
		return formula;
	}
	
	public void setFormula(Formula formula) {
		this.formula = formula;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	} 
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
}