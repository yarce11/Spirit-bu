package com.modisteria.dl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.modisteria.dl.model.Usuario;
import com.modisteria.dl.repositorio.UsuarioRepositorio;

@Controller()
public class UsuarioController  {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    @GetMapping("/")
    public String mostrarIndexRegistro(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "index";
    }
    @GetMapping("/registro")
    public String mostrarRegistro(@RequestParam(name = "status", required = false) String status, Model model) {
        if ("error".equals(status)) {
            String icon = "error";
            String titulo = "Registro anulado";
            String mensaje = "¡El correo ingresado ya se encuentra entre nuestros registros!";
            model.addAttribute("icon", icon);
            model.addAttribute("titulo", titulo);
            model.addAttribute("mensaje", mensaje);
        } 
        else if ("success".equals(status)) {
            String icon = "success";
            String titulo = "Registro exitoso";
            String mensaje = "¡El registro se ha realizado satisfactoriamente!";
            model.addAttribute("icon", icon);
            model.addAttribute("titulo", titulo);
            model.addAttribute("mensaje", mensaje);
        }

        return "registroAlert";
     }

     @PostMapping("/registro")
     public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
         if (usuarioRepositorio.existsByCorreo(usuario.getCorreo())) {
             return "redirect:/registro?status=error";
         }
         usuarioService.guardarUsuario(usuario);
         return "redirect:/registro?status=success";
     }
     
     @PostMapping("/inicioSesion")
     public String inicioSesion(@ModelAttribute("usuario") Usuario usuario) {
         if (usuarioRepositorio.existsByCorreo(usuario.getCorreo())) {
             return "redirect:/inicioSesion?status=success";
         }
         
        return "redirect:/registro?status=success";
     }

}
