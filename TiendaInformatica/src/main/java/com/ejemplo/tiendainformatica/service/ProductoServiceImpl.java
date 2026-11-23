package com.ejemplo.tiendainformatica.service;

import com.ejemplo.tiendainformatica.TiendaInformaticaApplication;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ejemplo.tiendainformatica.repository.ProductoRepository;
import com.ejemplo.tiendainformatica.model.Categoria;
import com.ejemplo.tiendainformatica.model.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	private final TiendaInformaticaApplication tiendaInformaticaApplication;
	@Autowired
	ProductoRepository productoRepository;

	ProductoServiceImpl(TiendaInformaticaApplication tiendaInformaticaApplication) {
		this.tiendaInformaticaApplication = tiendaInformaticaApplication;
	}
	
	@Override
	public List<Producto> getAll() {
		return productoRepository.findAll();
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

	@Override
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
