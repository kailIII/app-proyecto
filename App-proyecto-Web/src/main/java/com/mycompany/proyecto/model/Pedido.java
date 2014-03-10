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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase de Entidad mapeado por la tabla pedidos
 * de la BD
 * @author Rodrigo Garcete
 * @since 20/12/2013
 */
@Entity
@Table(name = "pedidos")
@NamedQueries({
	@NamedQuery(name = "Pedido.findAll", query = "SELECT NEW com.mycompany.proyecto.model.Pedido(p.codigo, p.estado, "
			+ "p.fecha, p.fechaVencimiento) FROM Pedido AS p ORDER BY p.codigo"),
	@NamedQuery(name = "Pedido.findById", query = "select p from Pedido p where p.codigo = :codigo"),
	@NamedQuery(name = "Pedido.findByEstado", query ="select p from Pedido p where p.estado LIKE :estado"),
	@NamedQuery(name = "Pedido.findByCombo", query = "SELECT NEW com.mycompany.proyecto.model.Pedido(p.codigo, p.estado)"
			+ " FROM Pedido AS p ORDER BY p.codigo")
})
public class Pedido extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String estado;

	//Se tendra en cuenta solo el dia, mes y ano.
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_registro")
	private Date fecha;
	
	@Column(name = "fecha_vencimiento")
	private Date fechaVencimiento;
	
	@Column(name = "fecha_recepcion")
	private Date fechaRecepcion;
	
	@Column(name = "total_exentas")
	private Double totalExentas;
	
	@Column(name = "total_gravada10")
	private Double totalGravada10;
	
	@Column(name = "total_gravada5")
	private Double totalGravada5;
	
	@Column(name = "total_iva10")
	private Double totalIva10;
	
	@Column(name = "total_iva5")
	private Double totalIva5;
	
	@ManyToOne
	@JoinColumn(name = "ped_proveedor_id")
	private Proveedor proveedor;

	/**
	 * MappedBy: informamos el nombre de la variable de instancia,
	 * que va a indicar a quien el One pertenece
	 * TargetEntity: informa cual es la asociacion entre las entidades
	 * FetchType.Lazy: Este tipo fue escogido por performance
	 * cascade: ALL para permitir alteraciones en todos los relacionamientos
	 */
	@OneToMany(mappedBy = "pedido", targetEntity = PedidoDetalle.class, 
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PedidoDetalle> pDetalles;

	//Constructor por Defecto
	public Pedido() {
		super();
		this.proveedor = new Proveedor();
	}
	
	public Pedido(Long codigo, String estado) {
		this.codigo = codigo;
		this.estado = estado;
	}
	
	public Pedido(Long codigo,  String estado, Date fecha, Date vencimiento){ 
		this.codigo = codigo;
		//this.proveedor = proveedor; Proveedor proveedor,
		this.estado = estado;
		this.fecha = fecha;
		this.fechaVencimiento = vencimiento;
	}

	//Metodos Getters and Setters
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public void setpDetalles(List<PedidoDetalle> pDetalles) {
		this.pDetalles = pDetalles;
	}
	
	public List<PedidoDetalle> getpDetalles() {
		return pDetalles;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public Double getTotalExentas() {
		return totalExentas;
	}

	public void setTotalExentas(Double totalExentas) {
		this.totalExentas = totalExentas;
	}

	public Double getTotalGravada10() {
		return totalGravada10;
	}

	public void setTotalGravada10(Double totalGravada10) {
		this.totalGravada10 = totalGravada10;
	}

	public Double getTotalGravada5() {
		return totalGravada5;
	}

	public void setTotalGravada5(Double totalGravada5) {
		this.totalGravada5 = totalGravada5;
	}

	public Double getTotalIva10() {
		return totalIva10;
	}

	public void setTotalIva10(Double totalIva10) {
		this.totalIva10 = totalIva10;
	}

	public Double getTotalIva5() {
		return totalIva5;
	}

	public void setTotalIva5(Double totalIva5) {
		this.totalIva5 = totalIva5;
	}

}