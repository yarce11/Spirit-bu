package com.modisteria.dl.controller;
import com.modisteria.dl.model.Estado;
import com.modisteria.dl.model.Permiso;
import com.modisteria.dl.service.PermisoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("permisos", permiso);
		model.addAttribute("permiso", new Permiso());
		return "permisos";
	}
	

	
	@PostMapping("/guardarPermiso")
	public String guardar(@Valid Permiso p, Model model) {
		service.guardar(p);
		return "redirect:/listarPermisos";
	}

	
	@GetMapping("/listarPermisos/{id}")
    public String editar(@PathVariable int id, Model model, @RequestParam(name = "action") String action) {
		List<Permiso> permiso = service.listar();
		model.addAttribute("permisos", permiso);
		model.addAttribute("permiso", new Permiso());
		
		Optional<Permiso> permisoE = service.listarId(id);
		model.addAttribute("permisoE", permisoE.get());

        boolean borrarPermiso = ("borrar".equals(action));
		boolean editPermiso = ("edit".equals(action));
        model.addAttribute("editPermiso", editPermiso);
		model.addAttribute("borrarPermiso", borrarPermiso);
		return "permisos";
    }
	
	@GetMapping("/eliminarPermiso/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/listarPermisos";
	}
}
