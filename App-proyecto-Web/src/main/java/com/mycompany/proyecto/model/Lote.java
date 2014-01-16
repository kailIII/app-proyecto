package com.mycompany.proyecto.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase de Entidad, cada objeto representa un registro 
 * de la tabla correspondiente
 * @author Rodrigo Garcete
 * @since 23/12/2013
 * Se utilizo JPA Proyections	
 */
@Entity
@Table(name = "lotes")
@NamedQueries({
	@NamedQuery(name="Lote.findById", query="SELECT i FROM Lote i WHERE i.codigo = :codigo"),
	@NamedQuery(name="Lote.findByName", query="SELECT i FROM Lote i WHERE i.nombre LIKE :nombre"),
	@NamedQuery(name="Lote.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Lote(i.codigo, i.nombre) FROM Lote AS i ORDER BY i.codigo"),
	@NamedQuery(name="Lote.findByAll", query="SELECT i FROM Lote i ORDER BY i.codigo")
})
public class Lote extends NamedEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;
	
	@Temporal(TemporalType.DATE)
	private Date vencimiento;

	private int activo;

	//Constructor por Defecto
	public Lote() {
		super();
		this.producto = new Producto();
	}
	
	public Lote(Long codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	//Metodos Getters and Setters
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	public Date getVencimiento() {
		return vencimiento;
	}
	
	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

}