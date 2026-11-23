package com.ejemplo.tiendainformatica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.tiendainformatica.model.Categoria;
import com.ejemplo.tiendainformatica.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	List<Producto> getByCategoria(Categoria categoria);
	List<Producto> getByEnOfertaTrue();
	List<Producto> getByCategoriaAndEnOfertaTrue(Categoria categoria);
}
