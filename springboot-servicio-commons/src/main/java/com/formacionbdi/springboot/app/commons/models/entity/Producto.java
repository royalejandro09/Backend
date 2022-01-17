package com.formacionbdi.springboot.app.commons.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "Productos")
public class Producto implements Serializable {

	/**
	 * Atributte.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private Double precio;

	/**
	 * Visualizacion del puerto que esta seleccionando el Balanceo de cargas.
	 */
	@Transient
	private Integer port;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date creatAt;

	/**
	 * Getter & Setter
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getCreatAt() {
		return creatAt;
	}

	public void setCreatAt(Date creatAt) {
		this.creatAt = creatAt;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * Serial Version Id.
	 */
	private static final long serialVersionUID = -8741085669949964091L;

}
