package com.formacionbdi.springboot.app.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.app.item.controllers.ItemController;
import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.commons.models.entity.Producto;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

	private final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
	
	/**
	 * Attribute.
	 */
	@Autowired
	private RestTemplate clienteRest;

	/**
	 * Methods.
	 */
	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays
				.asList(clienteRest.getForObject("http://servicio-productos/listar", Producto[].class));
		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, Long> pathVariables = new HashMap<String, Long>();
		pathVariables.put("id", id);
		Producto producto = clienteRest.getForObject("http://servicio-productos/ver/{id}", Producto.class,
				pathVariables);
		return new Item(producto, cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		HttpEntity<Producto> requestBody = new HttpEntity<Producto>(producto);

		ResponseEntity<Producto> response = clienteRest.exchange("http://servicio-productos/crear", HttpMethod.POST,
				requestBody, Producto.class);
		Producto productoResponse = response.getBody();
		return productoResponse;
	}

	@Override
	public Producto update(Producto producto, Long id) {
		Map<String, Long> pathVariables = new HashMap<String, Long>();
		pathVariables.put("id", id);

		HttpEntity<Producto> requestBody = new HttpEntity<Producto>(producto);

		ResponseEntity<Producto> response = clienteRest.exchange("http://servicio-productos/editar/{id}",
				HttpMethod.PUT, requestBody, Producto.class, pathVariables);

		return response.getBody();
	}

	@Override
	public void delete(Long id) {
		logger.info("id: {}", id);
		Map<String, Long> pathVariables = new HashMap<String, Long>();
		pathVariables.put("id", id);
		logger.info("id: {}", id);

		clienteRest.delete("http://servicio-productos/eliminar/{id}", pathVariables);
	}

}
