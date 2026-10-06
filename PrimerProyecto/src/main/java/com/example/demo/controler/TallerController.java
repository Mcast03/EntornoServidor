package com.example.demo.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Taller;

@Controller
@RequestMapping("/taller")
public class TallerController {

	private final List<Taller> talleres = cargadorTalleres();

	public List<Taller> cargadorTalleres() {
		List<Taller> ts = new ArrayList<>();

		ts.add(new Taller("Taller 1", 10, "A"));
		ts.add(new Taller("Taller 2", 15, "A"));
		ts.add(new Taller("Taller 3", 3, "B"));
		ts.add(new Taller("Taller 4", 12, "A"));
		ts.add(new Taller("Taller 5", 100, "B"));

		return ts;
	}

	private Taller dameIdTaller(int id) {
		for (Taller t : talleres) {
			if (t.getId() == id) {
				return t;
			}
		}
		return null;
	}
	
	private List<Taller> talleresPorTipo(String tipo) {
		List <Taller> listaTalleres = new ArrayList<>();
		for (Taller t : talleres) {
			if (t.getTipo().equals(tipo)) {
				listaTalleres.add(t);
			}
		}
		return listaTalleres;
	}

	@GetMapping("/uno/{id}")
	public String m(Model model, @PathVariable int id) {

		model.addAttribute("taller", dameIdTaller(id));
		return "taller/un-taller";
	}
	
	@GetMapping("/filtro/{tipo}")
	public String filtro(Model model, @PathVariable String tipo) {
		model.addAttribute("talleres", talleresPorTipo(tipo));
		model.addAttribute("titulo", "Lista de Tipo " + tipo);
		return "taller/dos-taller";
	}

	@GetMapping("/todos")
	public String todos(Model model) {
		model.addAttribute("talleres", talleres);
		model.addAttribute("titulo", "Lista Completa");
		return "taller/dos-taller";
	}

}
