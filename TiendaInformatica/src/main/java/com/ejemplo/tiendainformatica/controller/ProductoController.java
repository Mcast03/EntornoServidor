package com.ejemplo.tiendainformatica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejemplo.tiendainformatica.model.Categoria;
import com.ejemplo.tiendainformatica.model.Producto;
import com.ejemplo.tiendainformatica.service.IProductoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	@Qualifier("productoServiceImpl")
	IProductoService productoService;
	
	@GetMapping("/lista")
	public String lista(@RequestParam (defaultValue = "false") boolean oferta, @RequestParam (required = false) Categoria categoria ,Model model) {
		model.addAttribute("categoria", categoria.values());
		model.addAttribute("producto", productoService.filtrarByCategoriaAndOferta(categoria, oferta));
		model.addAttribute("tipoCategoria", categoria);
		model.addAttribute("enOferta", oferta);
		return "/tienda/lista";
	}
	
	@GetMapping("/ficha/{id}")
	public String lista(Model model, @PathVariable int id) {
		model.addAttribute("producto", productoService.getById(id));
		return "/tienda/ficha";
	}
	
	@PostMapping("/borrar/{id}")
	public String borrar(@PathVariable int id) {
		productoService.deleteById(id);
		return "redirect: /producto/lista";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(Model model, Categoria categoria, @PathVariable int id) {
		model.addAttribute("categoria", categoria.values());
		model.addAttribute("producto", productoService.getById(id));
		return "/tienda/formulario";
	}
	
	@GetMapping("/crear")
	public String crear(Model model, Categoria categoria, Producto producto) {
		model.addAttribute("categoria", categoria.values());
		model.addAttribute("producto", producto);
		return "/tienda/formulario";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid Producto producto, BindingResult resultado, Model model, Categoria categoria) {
		if(resultado.hasErrors()) {
			model.addAttribute("categoria", categoria.values());
			model.addAttribute("producto", producto);
			return "/tienda/formulario";
		}
		
		productoService.save(producto);
		return "redirect:/producto/lista";
	}

}
