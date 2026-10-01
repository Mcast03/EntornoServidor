package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/calculadora")
public class Calculadora {
	
	@GetMapping("/suma/{numero1}/{numero2}/{palabra}")
	public String suma(@PathVariable Integer numero1, @PathVariable Integer numero2, @PathVariable String palabra) {
		return "/calculadora/suma";
	}
}
