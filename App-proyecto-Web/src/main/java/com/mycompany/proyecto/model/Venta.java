package com.mycompany.proyecto.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ventas")
@NamedQueries({
	@NamedQuery(name="Venta.findById", query="SELECT c FROM Venta c WHERE c.codigo = :codigo"),
	@NamedQuery(name="Venta.findByEstado", query="SELECT c FROM Venta c WHERE c.estado LIKE :estado"),
	@NamedQuery(name="Venta.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Venta(c.codigo, c.estado) FROM Venta AS c ORDER BY c.codigo"),
	@NamedQuery(name="Venta.findByAll", query="SELECT c FROM Venta c ORDER BY c.codigo")
})
public class Venta extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name="fecha_registro")
	private Date fecha;
	
	@Column(name="fecha_documento")
	private Date fechaDocumento;
	
	@Column(name="comprobante_numero")
	private String comprobanteNumero;
	
	private String condicion;
	
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	@NotNull
	private Cliente cliente;
	
	private String obs;
	
	@Column(name="total_exentas")
	private Double totalExentas;
	
	@Column(name="total_gravada5")
	private Double totalGravada5;
	
	@Column(name="total_gravada10")
	private Double totalGravada10;

	@Column(name="total_iva5")
	private Double totalIva5;

	@Column(name="total_iva10")
	private Double totalIva10;
	
	@Column(name="monto_total")
	private Double montoTotal;
	
	/**
	 * MappedBy: informamos el nombre de la variable de instancia,
	 * que va a indicar a quien el One pertenece
	 * TargetEntity: informa cual es la asociacion entre las entidades
	 * FetchType.Lazy: Este tipo fue escogido por performance
	 * cascade: ALL para permitir alteraciones en todos los relacionamientos
	 */
	@OneToMany(mappedBy = "venta", targetEntity = VentaDetalle.class, 
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<VentaDetalle> items;
	
	//Constructores por Defecto
	public Venta() {
		super();
	}
	
	public Venta(Long codigo, String estado){
		this.codigo = codigo;
		this.estado = estado;
	}

	//Getters and Setters
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public String getComprobanteNumero() {
		return comprobanteNumero;
	}

	public void setComprobanteNumero(String comprobanteNumero) {
		this.comprobanteNumero = comprobanteNumero;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Double getTotalExentas() {
		return totalExentas;
	}

	public void setTotalExentas(Double totalExentas) {
		this.totalExentas = totalExentas;
	}

	public Double getTotalGravada5() {
		return totalGravada5;
	}

	public void setTotalGravada5(Double totalGravada5) {
		this.totalGravada5 = totalGravada5;
	}

	public Double getTotalGravada10() {
		return totalGravada10;
	}

	public void setTotalGravada10(Double totalGravada10) {
		this.totalGravada10 = totalGravada10;
	}

	public Double getTotalIva5() {
		return totalIva5;
	}

	public void setTotalIva5(Double totalIva5) {
		this.totalIva5 = totalIva5;
	}

	public Double getTotalIva10() {
		return totalIva10;
	}

	public void setTotalIva10(Double totalIva10) {
		this.totalIva10 = totalIva10;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	public List<VentaDetalle> getItems() {
		return items;
	}
	
	public void setItems(List<VentaDetalle> items) {
		this.items = items;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}
	
}