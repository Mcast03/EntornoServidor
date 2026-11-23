package com.ejemplo.tienda.Service;

import java.util.List;

import com.ejemplo.tienda.Model.Plataforma;
import com.ejemplo.tienda.Model.Videojuego;

public interface IVideojuegoService{
	List<Videojuego> darTodos();
	Videojuego darPorId(int id);
	void borrarPorId(int id);
	void save(Videojuego juego);
	List<Videojuego> dameFiltradas(Plataforma plataforma, boolean enOferta);
}
