package com.modisteria.dl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

import com.modisteria.dl.model.Estado;
import com.modisteria.dl.service.EstadoService;

import jakarta.validation.Valid;

@org.springframework.stereotype.Controller
@RequestMapping
public class EstadoController {
	
	@Autowired
	private EstadoService service;
	
	@GetMapping("/listarEstados")
	public String listar(Model model) {
		List<Estado> estado = service.listar();
		model.addAttribute("estados", estado);
		model.addAttribute("estado", new Estado());
		return "estados";
	}
	@GetMapping("/listarEstados/{id}")
	public String estadoId(@PathVariable int id, Model model, @RequestParam(name = "action") String action) {
		
		List<Estado> estado = service.listar();
		model.addAttribute("estados", estado);

		model.addAttribute("estado", new Estado());

		Optional<Estado> estadoE = service.listarId(id);
		model.addAttribute("estado", estadoE.get());
		
		boolean borrarEstado = ("borrar".equals(action));
		boolean editEstado = ("edit".equals(action));
        model.addAttribute("editEstado", editEstado);
        model.addAttribute("borrarEstado", borrarEstado);
		return "estados";
	}
	
	

	@PostMapping("/guardarEstado")
	public String guardar(@Valid Estado e) {
		service.guardar(e);
		return "redirect:/listarEstados";
	}
	
	@GetMapping("/eliminarEstado/{id}")
	public String eliminar(@PathVariable int id) {
		service.delete(id);
		return "redirect:/listarEstados";
	}
}
