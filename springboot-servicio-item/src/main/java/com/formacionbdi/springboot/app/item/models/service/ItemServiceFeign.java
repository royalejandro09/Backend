package com.formacionbdi.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.item.clientes.ProductoClienteRest;
import com.formacionbdi.springboot.app.item.controllers.ItemController;
import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.commons.models.entity.Producto;

@Service("servicefeign")
public class ItemServiceFeign implements ItemService {

	private final Logger logger = LoggerFactory.getLogger(ItemServiceFeign.class);
	/**
	 * Dependency of Injection. With @FeignClient(name="servicio-productos",
	 * url="localhost:8001")
	 */
	@Autowired
	private ProductoClienteRest clienteFeign;

	/**
	 * Methods.
	 */
	@Override
	public List<Item> findAll() {
		return clienteFeign.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.detalle(id), cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		return clienteFeign.crear(producto);
	}

	@Override
	public Producto update(Producto producto, Long id) {
		return clienteFeign.update(producto, id);
	}

	@Override
	public void delete(Long id) {
		logger.info("id: {}", id);
		clienteFeign.eliminar(id);
	}

}
