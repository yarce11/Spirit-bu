package com.modisteria.dl.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
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
    UsuarioService usuarioService;
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    RolRepositorio rolRepositorio;

    @GetMapping("/dashboard")
    public String usuarioAdmin() {
        return "dashboard";
    }
    @GetMapping("/usuarios/")
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
        model.addAttribute("usuarios", usuarios);

        List<Rol> roles = rolRepositorio.findAll();
        model.addAttribute("roles", roles);

        Usuario usuario = new Usuario();
        model.addAttribute("nuevoUsuario", usuario);

        Usuario usuarioId = usuarioService.listarId(id);
        model.addAttribute("usuarioId", usuarioId);

        boolean editCita = ("edit".equals(action));
        boolean borrarCita = ("borrar".equals(action));

        model.addAttribute("editcita", editCita);
        model.addAttribute("borrarCita", borrarCita);
        return "usuarios";
    }
    
    @PostMapping("/userAdd")
    public String registrarUsuario(@ModelAttribute("nuevoUsuario") Usuario usuario) {
        usuarioRepositorio.save(usuario);
        return "redirect:/usuarios/";
    }
    @PostMapping("/userEdit")
    public String editarUsuario( Model model, @RequestParam("id") Long id, @Validated Usuario usuarioForm ) {
        Usuario usuarioE = usuarioService.listarId(id);
        usuarioE.setCorreo(usuarioForm.getCorreo());
        usuarioE.setNombre_completo(usuarioForm.getNombre_completo());
        usuarioE.setTelefono(usuarioForm.getTelefono());
        usuarioE.setPassword(usuarioForm.getPassword());
        usuarioE.setRol(usuarioForm.getRol());

        usuarioRepositorio.save(usuarioE);
         return "redirect:/usuarios/";
     }

    
}
