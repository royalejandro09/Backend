package com.formacionbdi.springboot.app.item.models;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;

public class Item {

	/**
	 * Attribute.
	 */
	private Producto producto;
	private Integer cantidad;

	/**
	 * Constructor.
	 */
	public Item(Producto producto, Integer cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Item() {
	}

	/**
	 * Getter & Setter.
	 * 
	 * @return
	 */
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Method
	 */

	public Double getTotal() {
		return producto.getPrecio() * cantidad.doubleValue();
	}

}
