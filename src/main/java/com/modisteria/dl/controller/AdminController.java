package com.modisteria.dl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.modisteria.dl.model.Rol;
import com.modisteria.dl.model.Usuario;
import com.modisteria.dl.repositorio.RolRepositorio;
import com.modisteria.dl.repositorio.UsuarioRepositorio;
import com.modisteria.dl.service.UsuarioService;

@Controller

public class AdminController {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    RolRepositorio rolRepositorio;

    @GetMapping("/dashboard")
    public String usuarioAdmin() {
        return "dashboard";
    }
    @GetMapping("/usuarios")
    public String usuarioAdmin(Model model) {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        List<Rol> roles = rolRepositorio.findAll();
        Usuario usuario = new Usuario();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("nuevoUsuario", usuario);
        model.addAttribute("roles", roles);
        return "usuarios";
    }
    @GetMapping("/usuarios/{id}")
    public String usuarioId(@PathVariable Long id, Model model,@RequestParam(name="action") String action) {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        List<Rol> roles = rolRepositorio.findAll();
        Usuario usuario = new Usuario();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("nuevoUsuario", usuario);
        model.addAttribute("roles", roles);
        Optional<Usuario> usuarioId = usuarioRepositorio.findById(id);
        model.addAttribute("usuarioId", usuarioId);
        model.addAttribute("roles", roles);
        if (action == null)
    {
        return "redirect:/usuarios";
        }
        return "usuarios";
    }
    
    @PostMapping("/userAdd")
     public String registrarUsuario(@ModelAttribute("nuevoUsuario") Usuario usuario) {
         if (usuarioRepositorio.existsByCorreo(usuario.getCorreo())) {
             return "redirect:/registro?status=errorAdmin";
         }
         usuarioRepositorio.save(usuario);
         return "redirect:/usuarios";
     }

    
}
