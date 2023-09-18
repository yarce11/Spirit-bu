package com.modisteria.dl.controller;

import com.modisteria.dl.model.Citas;
import com.modisteria.dl.service.Cita_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {
    @Autowired
    private Cita_service service;

    @GetMapping("/new")
    public String agregar(Model model) {
        List<Citas> citas = service.listar();
        model.addAttribute("citas", citas);
        model.addAttribute("nuevaCita", new Citas());
        return "form";
    }

    /*@GetMapping("/new")
    public String agregar(Model model) {
        model.addAttribute("citas", new Citas());
        return "agregar";
    }
*/
    @PostMapping("/guardar")
    public String guardar(@Validated Citas C, @RequestParam("fechaStr") String fechaStr, Model model) {
        model.addAttribute("citas", new Citas());
        if (fechaStr != null && !fechaStr.isEmpty()) { // Verifica si fechaStr no es nulo ni vacío
            LocalDateTime fecha = C.convertirFecha();
            C.setFecha(fecha);
        } else {
            // Si fechaStr es nulo o vacío, podrías manejarlo de alguna manera, por ejemplo, mostrar un mensaje de error
            model.addAttribute("error", "La fecha no es válida"); // Agrega un mensaje de error al modelo
        }

        service.guardar(C);
        return "redirect:/new"; // Redirige a la URL "/listar" después de guardar los datos
    }
    /*
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Citas> cita = service.listaID(id);
        model.addAttribute("cita",cita);

        return "citas";
    }
    */


}
