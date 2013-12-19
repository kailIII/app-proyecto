package com.mycompany.proyecto.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "insumo_stock")
public class InsumoStock extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToMany
	@JoinColumn(name = "insumo_id")
	private Insumo insumo;
	
	@OneToMany
	@JoinColumn(name = "deposito_id")
	private Deposito deposito;
	
	private BigDecimal cantidad;
	
	@Column(name = "stock_minimo")
	private BigDecimal stockMinimo;
	
	@Column(name = "stock_maximo")
	private BigDecimal stockMaximo;
	
	//Constructor por Defecto
	public InsumoStock() {
		
	}

//	public Insumo getInsumo() {
//		return insumo;
//	}
//
//	public void setInsumo(Insumo insumo) {
//		this.insumo = insumo;
//	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(BigDecimal stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public BigDecimal getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(BigDecimal stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}
	
}