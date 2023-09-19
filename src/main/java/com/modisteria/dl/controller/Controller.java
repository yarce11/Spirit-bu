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

    @GetMapping("/vista")
    public String agregar(Model model) {
        List<Citas> citas = service.listar();
        model.addAttribute("citas", citas);
        model.addAttribute("nuevaCita", new Citas());
        return "form";
    }

    @PostMapping("/guardar")
    public String guardar(@Validated Citas C, @RequestParam("fechaStr") String fechaStr, Model model) {
        if (fechaStr != null && !fechaStr.isEmpty()) {
            LocalDateTime fecha = C.convertirFecha();
            C.setFecha(fecha);
            if (service.verificarFecha(C)){
                LocalDateTime fechaActual = LocalDateTime.now();
                LocalDateTime fecha1meses = fechaActual.plusMonths(1);
                if (fecha.isAfter(fecha1meses)){
                    return "redirect:/vista";
                }else{
                    if (fecha.isBefore(fechaActual)){
                        return "redirect:/vista";
                    }else {
                        service.guardar(C);
                        return "redirect:/vista";
                    }
                }
            }else{
                return "redirect:/vista";
            }
        } else {
            //return "redirect:/error?mensaje=La+fecha+no+es+válida.";
            return "redirect:/vista";
        }


    }



}
