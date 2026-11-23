package com.ejemplo.tiendainformatica.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ejemplo.tiendainformatica.model.Categoria;
import com.ejemplo.tiendainformatica.model.Producto;
import com.ejemplo.tiendainformatica.repository.ProductoRepository;

public class ProductoServiceEnStockImp implements IProductoService{

	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public List<Producto> getAll() {
		List<Producto> enStock = new ArrayList<>();
		for(Producto producto : productoRepository.findAll()) {
			if (producto.getStock() > 0) {
				enStock.add(producto);
			}
		}
		return enStock;
	}

	@Override
	public Producto getById(int id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
		productoRepository.deleteById(id);	
	}

	@Override
	public void save(Producto producto) {
		productoRepository.save(producto);
	}
	
	public List<Producto> filtrarByCategoriaAndOferta(Categoria categoria, boolean oferta) {
		if(categoria == null && !oferta) {
			return productoRepository.findAll();
		}
		
		if(categoria == null) {
			return productoRepository.getByEnOfertaTrue();
		}
		
		if(!oferta) {
			return productoRepository.getByCategoria(categoria);
		}
		return productoRepository.getByCategoriaAndEnOfertaTrue(categoria);
	}

}
