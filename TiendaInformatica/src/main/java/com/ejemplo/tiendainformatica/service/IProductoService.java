package com.ejemplo.tiendainformatica.service;

import java.util.List;

import com.ejemplo.tiendainformatica.model.Categoria;
import com.ejemplo.tiendainformatica.model.Producto;

public interface IProductoService{
	List<Producto> getAll();
	Producto getById(int id);
	void deleteById(int id);
	void save(Producto producto);
	List<Producto> filtrarByCategoriaAndOferta(Categoria categoria, boolean oferta);
}
