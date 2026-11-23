package com.ejemplo.tienda.Controller;

import com.ejemplo.tienda.Repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejemplo.tienda.Model.Plataforma;
import com.ejemplo.tienda.Model.Videojuego;
import com.ejemplo.tienda.Service.IVideojuegoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/videojuego")
public class VideojuegoController {
	@Autowired
	@Qualifier("videojuegoServiceImpl")
	private IVideojuegoService videojuegoService;

	
	@GetMapping("/lista")
	public String lista(Model model, @RequestParam(required = false) Plataforma plataforma,
			@RequestParam(defaultValue = "false") boolean enOferta) {
		model.addAttribute("videojuego", videojuegoService.dameFiltradas(plataforma, enOferta));
		model.addAttribute("plataforma", plataforma.values());
		model.addAttribute("plataformaElegida", plataforma);
		model.addAttribute("enOferta", enOferta);
		
		return "/videojuego/lista";
	}
	
	@GetMapping("/ficha/{id}")
	public String ficha(Model model, @PathVariable int id) {
		model.addAttribute("juego", videojuegoService.darPorId(id));
		return "/videojuego/ficha";
	}
	
	@PostMapping("/borrar/{id}")
	public String borrar(@PathVariable int id) {
		videojuegoService.borrarPorId(id);
		return "redirect:/videojuego/lista";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model, Plataforma plataforma) {
		model.addAttribute("plataforma", plataforma.values());
		model.addAttribute("videojuego", new Videojuego());
		return "/videojuego/formulario";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(Model model, @PathVariable int id, Plataforma plataforma) {
		model.addAttribute("videojuego", videojuegoService.darPorId(id));
		model.addAttribute("plataforma", plataforma.values());
		return "/videojuego/formulario";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("videojuego")Videojuego juego,
			BindingResult resultado, Model model, Plataforma plataforma) {
		
		if(resultado.hasErrors()) {
			model.addAttribute("plataforma", plataforma.values());
			return "/videojuego/formulario";
		}
		
		videojuegoService.save(juego);
		return "redirect:/videojuego/lista";
	}


}
