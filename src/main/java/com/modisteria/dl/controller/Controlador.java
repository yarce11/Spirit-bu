package com.modisteria.dl.controller;

import com.modisteria.dl.model.Citas;
import com.modisteria.dl.service.Cita_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping
public class Controlador {
    @Autowired
    private Cita_service service;
    @GetMapping("/listar")
    public String listar(Model model){
        List<Citas>citas=service.listar();
        model.addAttribute("citas", citas);
        return "citas";
    }
    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("citas", new Citas());
        return "form";
    }
    @PostMapping("/guardar")
    public String guardar(@Validated Citas C, @RequestParam("fechaStr") String fechaStr, Model model) {
        if (fechaStr != null && !fechaStr.isEmpty()) { // Verifica si fechaStr no es nulo ni vacío
            LocalDateTime fecha = C.convertirFecha();
            C.setFecha(fecha);
        } else {
            // Si fechaStr es nulo o vacío, podrías manejarlo de alguna manera, por ejemplo, mostrar un mensaje de error
            model.addAttribute("error", "La fecha no es válida"); // Agrega un mensaje de error al modelo
        }

        service.guardar(C);
        return "redirect:/citas";
    }


}
