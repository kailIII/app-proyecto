package com.mycompany.proyecto.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "recepcion_insumos")
public class RecepcionInsumo extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private Date fecha;
	
	private int proveedor;
	
	private int empleado;

	public RecepcionInsumo() {
		
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getProveedor() {
		return proveedor;
	}

	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}

	public int getEmpleado() {
		return empleado;
	}

	public void setEmpleado(int empleado) {
		this.empleado = empleado;
	}
	
}