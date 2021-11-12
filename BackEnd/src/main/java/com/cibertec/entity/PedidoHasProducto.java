package com.cibertec.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido_has_producto")
public class PedidoHasProducto {

	@EmbeddedId
	private PedidoHasProductoPK pedidoHasProductoPK;
	private double precio;
	private int cantidad;

	@ManyToOne
	@JoinColumn(name = "idPedido", nullable = false, insertable = false, updatable = false)
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "idProducto", nullable = false, insertable = false, updatable = false)
	private Producto producto;

	public PedidoHasProductoPK getPedidoHasProductoPK() {
		return pedidoHasProductoPK;
	}

	public void setPedidoHasProductoPK(PedidoHasProductoPK pedidoHasProductoPK) {
		this.pedidoHasProductoPK = pedidoHasProductoPK;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
