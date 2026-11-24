package com.example.gimnasio.controller;

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

import com.example.gimnasio.model.Ejercicio;
import com.example.gimnasio.model.Grupo;
import com.example.gimnasio.service.IEjercicioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/gimnasio")
public class EjercicioController {
	@Autowired
	@Qualifier("ejercicioServiceImpl")
	IEjercicioService ejercicioService;
	
	@GetMapping("/lista")
	public String lista(Model model, @RequestParam (defaultValue="false") boolean maquina, @RequestParam (required=false) Grupo grupo) {
		model.addAttribute("ejercicios", ejercicioService.filtrarPorGrupoAndMaquina(grupo, maquina));
		model.addAttribute("grupos", grupo.values());
		model.addAttribute("grupo", grupo);
		model.addAttribute("maquina", maquina);
		return "/ejercicios/lista";
	}
	
	@PostMapping("/borrar/{id}")
	public String borrar(@PathVariable int id) {
		ejercicioService.deleteById(id);
		return "redirect: /gimnasio/lista";
	}
	
	@GetMapping("/crear")
	public String crear(Ejercicio ejercicio, Grupo grupo ,Model model) {
		model.addAttribute("grupo", grupo.values());
		model.addAttribute("ejercicio", ejercicio);
		return "/ejercicios/formulario";
	}
	
	@GetMapping("/editar/{id}")
	public String crear(Ejercicio ejercicio, Grupo grupo, Model model, @PathVariable int id) {
		model.addAttribute("grupo", grupo.values());
		model.addAttribute("ejercicio", ejercicioService.getById(id));
		return "/ejercicios/formulario";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid Ejercicio ejercicio, BindingResult resultado, Model model, Grupo grupo) {
		if(resultado.hasErrors()) {
			model.addAttribute("grupo", grupo.values());
			model.addAttribute("ejercicio", ejercicio);
			return "/ejercicios/formulario";
		}
		
		ejercicioService.save(ejercicio);
		return "redirect: /gimnasio/lista";
	}
	
	@GetMapping("/ficha/{id}")
	public String ficha(Model model, @PathVariable int id) {
		model.addAttribute("ejercicio", ejercicioService.getById(id));
		return "/ejercicios/ficha";
	}
}
