package com.modisteria.dl.controller;
import com.modisteria.dl.model.Rol;
import com.modisteria.dl.service.RolService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
@org.springframework.stereotype.Controller
@RequestMapping
public class RolController {
	
	@Autowired
	private RolService service;
	
	@GetMapping("/listarRoles")
	public String listar(Model model) {
		List<Rol> rol = service.listar();
		model.addAttribute("estados", rol);
		return "estados";
	}
	
	@GetMapping("/nuevoRol")
	public String agregar(Model model) {
		model.addAttribute("permiso", new Rol());
		return "nuevoRol";
	}
	
	@PostMapping("/guardarRol")
	public String guardar(@Valid Rol r, Model model) {
		service.guardar(r);
		return "redirect:/listarRoles";
	}

	
	@GetMapping("/editarRol/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Rol> rol = service.listarId(id);
        if (rol.isPresent()) {
            model.addAttribute("rol", rol.get());
            return "editarRol";
        } else {
            return "redirect:/listarRoles";
        }
    }
	
	@GetMapping("/eliminarRol/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		service.delete(id);
		return "redirect:/listarRoles";
	}
}
