 package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SaludaController {

	// /saludo?nombre=Javier&apellido=Luque

	@GetMapping("/saludo")
	public String saludoHandler(Model model, @RequestParam (required = false, defaultValue = "Antonio") String nombre, @RequestParam (required = false) String apellido) {
		model.addAttribute("nombre", nombre);
		model.addAttribute("apellido",apellido);
		return "/saludo/home";
	}
}
