package com.formacionbdi.springboot.app.item.models.service;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;

import java.util.List;

import com.formacionbdi.springboot.app.item.models.Item;

public interface ItemService {

	/**
	 * Methods.
	 */
	public List<Item> findAll();

	public Item findById(Long id, Integer cantidad);

	public Producto save(Producto producto);

	public Producto update(Producto producto, Long id);

	public void delete(Long id);

}
