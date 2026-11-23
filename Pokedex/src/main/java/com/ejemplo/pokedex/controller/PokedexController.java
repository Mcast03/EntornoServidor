package com.ejemplo.pokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejemplo.pokedex.model.Pokemon;
import com.ejemplo.pokedex.model.Tipo;
import com.ejemplo.pokedex.service.IPokedexService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pokemon")
public class PokedexController {
	@Autowired
	@Qualifier("pokemonServiceImpl")
	public IPokedexService pokedexService;

	@GetMapping("/lista")
	public String lista(@RequestParam (required=false) Tipo tipo, @RequestParam (defaultValue="false") boolean legendario, Model model) {
		
		model.addAttribute("pokemon", pokedexService.filtrarPokemons(tipo, legendario));
		model.addAttribute("tipo", tipo.values());
		model.addAttribute("legendario", legendario);
		model.addAttribute("tipoElegido", tipo);
		return "pokedex/lista";
	}

	@GetMapping("/ficha/{id}")
	public String ficha(Model model, @PathVariable int id) {
		model.addAttribute("pokemon", pokedexService.getById(id));
		return "pokedex/ficha";
	}

	@PostMapping("/borrar/{id}")
	public String borrar(@PathVariable int id) {
		pokedexService.deleteById(id);
		return "redirect: /pokemon/lista";
	}

	@GetMapping("/anadir")
	public String crear(Model model, Pokemon pokemon, Tipo tipo) {
		model.addAttribute("pokemon", pokemon);
		model.addAttribute("tipo", tipo.values());
		return "pokedex/formulario";
	}

	@GetMapping("/editar/{id}")
	public String editar(Model model, @PathVariable int id, Tipo tipo) {
		model.addAttribute("pokemon", pokedexService.getById(id));
		model.addAttribute("tipo", tipo.values());
		return "pokedex/formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("pokemon") Pokemon pokemon, BindingResult resultado, Model model,
			Tipo tipo) {

		if (resultado.hasErrors()) {
			model.addAttribute("tipo", tipo.values());
			model.addAttribute("pokemon", pokemon);
			return "pokedex/formulario";
		}

		pokedexService.save(pokemon);
		return "redirect: /pokemon/lista";
	}
}
