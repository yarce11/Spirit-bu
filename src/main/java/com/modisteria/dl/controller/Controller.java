package com.modisteria.dl.controller;

import com.modisteria.dl.model.Citas;
import com.modisteria.dl.service.Cita_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public String guardar(@Validated Citas C, @RequestParam("fechaStr") String fechaStr) {
        if (fechaStr != null && !fechaStr.isEmpty()) {
            LocalDateTime fecha = C.convertirFecha();
            C.setFecha(fecha);
            if (service.verificarFecha(C)){
                LocalDateTime fechaActual = LocalDateTime.now();
                LocalDateTime fecha1mes = fechaActual.plusMonths(1);
                if (fecha.isAfter(fecha1mes)){
                    return "redirect:/vista";
                }else{
                    if (fecha.isBefore(fechaActual)){
                        return "redirect:/vista";
                    }else {
                        List<Citas> citasExist = service.listar();
                        LocalDateTime minima = fecha.minusHours(2);
                        LocalDateTime maxima = fecha.plusHours(2);

                        boolean hayConflictos = citasExist.stream().anyMatch(cita -> (cita.getFecha().isAfter(minima) && cita.getFecha().isBefore(maxima)));
                        if (hayConflictos) {
                            return "redirect:/vista";
                        } else {
                            DayOfWeek dia_semana = fecha.getDayOfWeek();
                            int dia = dia_semana.getValue();
                            switch (dia){
                                case 6:
                                    return "redirect:/vista";
                                case 7:
                                    return "redirect:/vista";
                                default:
                                    int hora = fecha.getHour();
                                    if (hora >=8 && hora <=17){
                                        service.guardar(C);
                                        return "redirect:/vista";
                                    }else{
                                        return "redirect:/vista";
                                    }
                            }
                        }
                    }
                }
            }else{
                return "redirect:/vista";
            }
        } else {
            return "redirect:/vista";
        }
    }
    @GetMapping("/editar/{id}")
    public String editarCita(@PathVariable("id") int id, Model model) {
        Citas cita = service.listaID(id);
        if (cita != null) {
            model.addAttribute("citaE", cita);
            return "editar";
        } else {
            return "redirect:/vista";
        }
    }

    @PostMapping("/guardarEdicion")
    public String guardarEdicion(@Validated Citas cita, @RequestParam("id") int id) {
        Citas citaExistente = service.listaID(id);

        if (citaExistente != null) {
            LocalDateTime fecha = cita.getFecha(); // Obtener la fecha de la cita

            if (fecha != null) {
                LocalDateTime fechaActual = LocalDateTime.now();
                LocalDateTime fecha1mes = fechaActual.plusMonths(1);

                if (fecha.isAfter(fecha1mes)) {
                    return "redirect:/vista";
                } else if (fecha.isBefore(fechaActual)) {
                    return "redirect:/vista";
                } else {
                    List<Citas> citasExist = service.listar();
                    LocalDateTime minima = fecha.minusHours(2);
                    LocalDateTime maxima = fecha.plusHours(2);

                    boolean hayConflictos = citasExist.stream().anyMatch(c -> (c.getFecha().isAfter(minima) && c.getFecha().isBefore(maxima)));
                    if (hayConflictos) {
                        return "redirect:/vista";
                    } else {
                        DayOfWeek dia_semana = fecha.getDayOfWeek();
                        int dia = dia_semana.getValue();
                        switch (dia) {
                            case 6:
                                return "redirect:/vista";
                            case 7:
                                return "redirect:/vista";
                            default:
                                int hora = fecha.getHour();
                                if (hora >= 8 && hora <= 17) {
                                    citaExistente.setEstado(cita.getEstado());
                                    citaExistente.setFecha(cita.getFecha());
                                    citaExistente.setObjetivo(cita.getObjetivo());
                                    citaExistente.setUsuario(cita.getUsuario());

                                    service.actualizar(citaExistente);
                                    return "redirect:/vista";
                                } else {
                                    return "redirect:/vista";
                                }
                        }
                    }
                }
            }
        }
        return "redirect:/vista";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarCita(@PathVariable("id") int id) {
        service.eliminar(id);
        return "redirect:/vista";
    }








}
