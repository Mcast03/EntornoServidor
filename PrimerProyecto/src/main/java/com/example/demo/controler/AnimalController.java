package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.IAnimalService;

@Controller
@RequestMapping("/animal")
public class AnimalController {

	private final IAnimalService animalService;

	public AnimalController(IAnimalService animalService) {
		this.animalService = animalService;
	}

	@ModelAttribute(name = "titulo")
	public String titulo() {
		return "Tienda de animales";
	}
	
	@GetMapping("/todos")
	public String todos(Model model, @RequestParam(required = false) String tipo,
			@RequestParam(defaultValue = "false") boolean soloOferta) {
		model.addAttribute("animales", animalService.dameFiltrados(tipo, soloOferta));
		model.addAttribute("tipos", animalService.dameTipos());
		model.addAttribute("tipo", tipo);
		model.addAttribute("soloOferta", soloOferta);
		return "animales/lista";
	}

	@GetMapping("/id/{id}")
	public String unoPorId(Model model, @PathVariable int id) {
		model.addAttribute("animal", animalService.damePorId(id));
		return "animales/un-animal";
	}

}