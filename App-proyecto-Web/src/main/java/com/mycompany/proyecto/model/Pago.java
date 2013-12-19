package com.mycompany.proyecto.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table (name = "pagos")
public class Pago extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Date fechaDocumento;
	
	private Date fechaOperacion;
	
	private String tipo;
	
	private Set<Operacion> operacionTipo;
	
	private String reciboNumero;
	
	private Set<Cuenta> cuenta;
	
	private BigDecimal cotizacion;
	
	private Set<Proveedor> proveedor;
	
	private BigDecimal monto_total;
	
	private int activo;
	
	private String obs;
	
	public Pago() {
		
	}

	public Date getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public Date getFechaOperacion() {
		return fechaOperacion;
	}

	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<Operacion> getOperacionTipo() {
		return operacionTipo;
	}

	public void setOperacionTipo(Set<Operacion> operacionTipo) {
		this.operacionTipo = operacionTipo;
	}

	public String getReciboNumero() {
		return reciboNumero;
	}

	public void setReciboNumero(String reciboNumero) {
		this.reciboNumero = reciboNumero;
	}

	public Set<Cuenta> getCuenta() {
		return cuenta;
	}

	public void setCuenta(Set<Cuenta> cuenta) {
		this.cuenta = cuenta;
	}

	public BigDecimal getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(BigDecimal cotizacion) {
		this.cotizacion = cotizacion;
	}

	public Set<Proveedor> getProveedor() {
		return proveedor;
	}

	public void setProveedor(Set<Proveedor> proveedor) {
		this.proveedor = proveedor;
	}

	public BigDecimal getMonto_total() {
		return monto_total;
	}

	public void setMonto_total(BigDecimal monto_total) {
		this.monto_total = monto_total;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
}