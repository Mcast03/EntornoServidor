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

		ts.add(new Taller("Taller 1", 10));
		ts.add(new Taller("Taller 2", 15));
		ts.add(new Taller("Taller 3", 3));
		ts.add(new Taller("Taller 4", 12));
		ts.add(new Taller("Taller 5", 100));

		return ts;
	}
	
	
	private Taller dameIdTaller(int id) {
		for (Taller t : talleres) {
			if(t.getId() == id) {
				return t;
			}
		}
		return null;
	}
	

	@GetMapping("/uno/{id}")
	public String m(Model model, @PathVariable int id) {
	
		model.addAttribute("taller", dameIdTaller(id));
		return "taller/un-taller";
	}
	
	
	@GetMapping("/todos")
	public String todos(Model model) {
		model.addAttribute("talleres", talleres);
		return "taller/dos-taller";
	}

}
