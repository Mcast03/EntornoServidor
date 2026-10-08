package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Loteria;

@Controller
@RequestMapping("/loto")
public class LoteriaController {
	
	public List<Loteria> generadorPaises(){
		List <Loteria> paises = new ArrayList<>();
		
		paises.add(new Loteria("España", 6, 49));
		paises.add(new Loteria("Alemania", 6, 49));
		paises.add(new Loteria("Francia", 6, 90));
		paises.add(new Loteria("Italia", 5, 49));
		
		return paises;
	}
	
	@GetMapping("/menu")
	public String Menu(Model model) {
		model.addAttribute("paises", generadorPaises());
		return "loto";
	}
	
	
	public List<Integer> numeroGanador(Integer max, Integer cantidad){
		List <Integer> ganadores = new ArrayList<>();
		Integer cont = 0;
		Random rm = new Random();
		do {
			Integer num = rm.nextInt(1,max+1);
			 
			if (!ganadores.contains(num)) {
				ganadores.add(num);
				cont++;
			}
			
		}while(cont < cantidad);
		return ganadores;
	}
	
	@GetMapping("/genera/{max}/{cantidad}/{pais}")
	public String boombo(Model model, @PathVariable Integer max, @PathVariable Integer cantidad, @PathVariable String pais) {
		model.addAttribute("ganadores", numeroGanador(max, cantidad));
		return "loto";
	}
}
