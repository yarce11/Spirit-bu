package com.modisteria.dl.controller;
import com.modisteria.dl.model.Permiso;
import com.modisteria.dl.service.PermisoService;
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
public class PermisoController {
	
	@Autowired
	private PermisoService service;
	
	@GetMapping("/listarPermisos")
	public String listar(Model model) {
		List<Permiso> permiso = service.listar();
		model.addAttribute("estados", permiso);
		return "estados";
	}
	
	@GetMapping("/nuevoPermiso")
	public String agregar(Model model) {
		model.addAttribute("permiso", new Permiso());
		return "nuevoPermiso";
	}
	
	@PostMapping("/guardarPermiso")
	public String guardar(@Valid Permiso p, Model model) {
		service.guardar(p);
		return "redirect:/listarPermisos";
	}

	
	@GetMapping("/editarPermiso/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Permiso> permiso = service.listarId(id);
        if (permiso.isPresent()) {
            model.addAttribute("estado", permiso.get());
            return "editarPermiso";
        } else {
            return "redirect:/listarPermisos";
        }
    }
	
	@GetMapping("/eliminarPermiso/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/listarPermisos";
	}
}
