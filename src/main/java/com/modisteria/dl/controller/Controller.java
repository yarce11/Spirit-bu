package com.modisteria.dl.controller;

import com.modisteria.dl.model.Citas;
import com.modisteria.dl.service.Cita_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {
    @Autowired
    private Cita_service service;

    @GetMapping("/vista")
    public String vista(Model model) {
        List<Citas> citas = service.listar();
        model.addAttribute("citas", citas);
        model.addAttribute("nuevaCita", new Citas());
        return "form";
    }


    @PostMapping("/guardar")
    public String guardar(@Validated Citas C, @RequestParam("fechaStr") String fechaStr, Model model) {
        if (fechaStr != null && !fechaStr.isEmpty()) {//Dentro de este metodo no instanciamos objetos ya que ya fueron instanciados dentro del motodo vista
            LocalDateTime fecha = C.convertirFecha();
            C.setFecha(fecha);
        } else {
            model.addAttribute("error", "La fecha no es válida");
        }

        service.guardar(C);
        return "redirect:/vista";
    }
    @GetMapping("/citas/editar/{id}")
    public String form_editar(@PathVariable int id, Model model){
        model.addAttribute("cita",service.listaID(id));
        return "vista";
    }

    @PostMapping("/citas/{id}")
    public String editar(@PathVariable int id, @ModelAttribute("cita")Citas citas, Model model){
        Citas cita_existente = service.listaID(id);
        cita_existente.setId(id);
        cita_existente.setUsuario(citas.getUsuario());
        cita_existente.setObjetivo(citas.getObjetivo());
        cita_existente.setFecha(citas.getFecha());
        cita_existente.setImagen(citas.getImagen());

        service.actualizar(cita_existente);
        return "redirect:/vista";
    }

    @GetMapping("/citas/{id}")
    public String eliminar(@PathVariable int id){
        service.eliminar(id);
        return "vista";
    }



}
