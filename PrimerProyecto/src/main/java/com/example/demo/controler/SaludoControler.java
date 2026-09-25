package com.example.demo.controler;

import java.util.random.RandomGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/saludo")
public class SaludoControler {

	@GetMapping("/saludo1/{nombre}/{apellido}")
	public String m(@PathVariable String nombre, @PathVariable String apellido) {

//		model.addAttribute("nombre", nombre);
//		model.addAttribute("apellido", apellido);

		return "saludo/hola";
	}

	@GetMapping("/saludo1")
	public String dado(Model model) {
		model.addAttribute("dado", RandomGenerator.getDefault().nextInt(1, 7));
		return "saludo/dado";
	}
}
