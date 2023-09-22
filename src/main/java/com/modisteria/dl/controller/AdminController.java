package com.modisteria.dl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.modisteria.dl.model.Usuario;
import com.modisteria.dl.repositorio.UsuarioRepositorio;

@Controller

public class AdminController {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @GetMapping("/dashboard")
    public String usuarioAdmin() {
        return "dashboard";
    }
    @GetMapping("/usuarios")
    public String usuarioAdmin(Model model){
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }
    
}
