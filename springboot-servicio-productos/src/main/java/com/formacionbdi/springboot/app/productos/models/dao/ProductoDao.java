package com.formacionbdi.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{ 
	
	/**
	 * No es necesario anotar con ninguna anotacion @ ya que 
	 * se hereda de CrudRepository y este por defecto ya es un componente manejado por Spring
	 * por lo tanto ya lo podemos inyectar.
	 */

}
