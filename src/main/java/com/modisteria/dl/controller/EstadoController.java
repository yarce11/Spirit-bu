package com.modisteria.dl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
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
		return "estados";
	}
	
	@GetMapping("/nuevoEstado")
	public String agregar(Model model) {
		model.addAttribute("estado", new Estado());
		return "nuevoEstado";
	}
	
	@PostMapping("/guardarEstado")
	public String guardar(@Valid Estado e, Model model) {
		service.guardar(e);
		return "redirect:/listarEstados";
	}
	
	
	@GetMapping("/editarEstado/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Estado> estado = service.listarId(id);
        if (estado.isPresent()) {
            model.addAttribute("estado", estado.get());
            return "editarEstado";
        } else {
            return "redirect:/listarEstados";
        }
    }
	
	@GetMapping("/eliminarEstado/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/listarEstados";
	}
}
