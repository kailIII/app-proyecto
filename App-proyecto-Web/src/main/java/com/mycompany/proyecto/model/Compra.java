package com.mycompany.proyecto.model;

import java.math.BigDecimal;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Entidad Compra que representa la tabla del mismo nombre
 * @author Rodrigo Garcete
 * @since 05/01/2014
 *
 */
@Entity
@Table(name = "compras")
@NamedQueries({
	@NamedQuery(name="Compra.findById", query="SELECT c FROM Compra c WHERE c.codigo = :codigo"),
	@NamedQuery(name="Compra.findByEstado", query="SELECT c FROM Compra c WHERE c.estado LIKE :estado"),
	@NamedQuery(name="Compra.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Compra(c.codigo, c.estado) FROM Compra AS c ORDER BY c.codigo"),
	@NamedQuery(name="Compra.findByAll", query="SELECT c FROM Compra c ORDER BY c.codigo")
})
public class Compra extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_documento")
	@NotNull
	private Date fechaDocumento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro")
	@NotNull
	private Date fechaRegistro;

	@Column(name = "comprobante_numero")
	@NotNull
	private String comprobanteNumero;

	/**
	 * MappedBy: informamos el nombre de la variable de instancia,
	 * que va a indicar a quien el One pertenece
	 * TargetEntity: informa cual es la asociacion entre las entidades
	 * FetchType.Lazy: Este tipo fue escogido por performance
	 * cascade: ALL para permitir alteraciones en todos los relacionamientos
	 */
	@OneToMany(mappedBy = "compra", targetEntity = CompraDetalle.class, 
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CompraDetalle> cDetalles;

	@ManyToOne
	@JoinColumn(name = "com_proveedor_id")
	@NotNull
	private Proveedor proveedor;

	@Column(name = "total_exentas")
	private BigDecimal totalExentas;

	@Column(name = "total_gravada10")
	private BigDecimal totalGravada10;

	@Column(name = "total_gravada5")
	private BigDecimal totalGravada5;

	@Column(name = "total_iva10")
	private BigDecimal totalIva10;

	@Column(name = "total_iva5")
	private BigDecimal totalIva5;

	@Column(name = "monto_total")
	private BigDecimal montoTotal;

	private String condicion;

	private String estado;

	private String obs;

	// Constructores por Defecto
	public Compra() {
		super();
		this.proveedor = new Proveedor();
	}
	
	public Compra(Long codigo, String estado) {
		this.codigo = codigo;
		this.estado = estado;
	}

	//Metodos Getters and Setters
	public Date getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public BigDecimal getTotalGravada5() {
		return totalGravada5;
	}

	public void setTotalGravada5(BigDecimal totalGravada5) {
		this.totalGravada5 = totalGravada5;
	}

	public BigDecimal getTotalGravada10() {
		return totalGravada10;
	}

	public void setTotalGravada10(BigDecimal totalGravada10) {
		this.totalGravada10 = totalGravada10;
	}

	public BigDecimal getTotalIva5() {
		return totalIva5;
	}

	public void setTotalIva5(BigDecimal totalIva5) {
		this.totalIva5 = totalIva5;
	}

	public BigDecimal getTotalIva10() {
		return totalIva10;
	}

	public void setTotalIva10(BigDecimal totalIva10) {
		this.totalIva10 = totalIva10;
	}

	public String getComprobanteNumero() {
		return comprobanteNumero;
	}

	public void setComprobanteNumero(String comprobanteNumero) {
		this.comprobanteNumero = comprobanteNumero;
	}

	public BigDecimal getTotalExentas() {
		return totalExentas;
	}

	public void setTotalExentas(BigDecimal totalExentas) {
		this.totalExentas = totalExentas;
	}

	public BigDecimal getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public void setcDetalles(List<CompraDetalle> cDetalles) {
		this.cDetalles = cDetalles;
	}
	
	public List<CompraDetalle> getcDetalles() {
		return cDetalles;
	}
	
}