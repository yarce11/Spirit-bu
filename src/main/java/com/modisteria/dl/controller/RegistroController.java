package com.modisteria.dl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.modisteria.dl.model.Usuario;
import com.modisteria.dl.repositorio.UsuarioRepositorio;

@Controller()
public class RegistroController {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @GetMapping("/")
     public String mostrarIndexRegistro(Model model) {
          Usuario usuario = new Usuario();
         model.addAttribute("usuario", usuario);
         return "index";
     }
     @PostMapping("/registro")
     public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioRepositorio.save(usuario);
        return "index";
     }

}
