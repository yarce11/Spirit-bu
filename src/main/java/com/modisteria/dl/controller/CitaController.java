package com.modisteria.dl.controller;

import com.modisteria.dl.model.Citas;
import com.modisteria.dl.model.Estado;
import com.modisteria.dl.service.Cita_service;
import com.modisteria.dl.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;



@org.springframework.stereotype.Controller
@RequestMapping
public class CitaController {
    @Autowired
    private Cita_service service;
    @Autowired
    private EstadoService serviceEstado;

    @GetMapping("/vista")
    public String vista(Model model) {
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
            Estado estadoPredeterminado = serviceEstado.obtenerEstadoPrePorid(1);
            C.setEstado(estadoPredeterminado);
            if (service.verificarFecha(C)) {
                LocalDateTime fechaActual = LocalDateTime.now();
                LocalDateTime fecha1mes = fechaActual.plusMonths(1);
                if (fecha.isAfter(fecha1mes)) {
                    String icon = "error";
                    String titulo = "Cita cancelada";
                    String mensaje = "¡Solo puedes solicitar citas dentro de un rango de tiempo de un mes!";
                    model.addAttribute("icon", icon);
                    model.addAttribute("titulo", titulo);
                    model.addAttribute("mensaje", mensaje);
                } else {
                    if (fecha.isBefore(fechaActual)) {
                        String icon = "error";
                        String titulo = "Cita cancelada";
                        String mensaje = "¡La fecha y hora que indicaste ya pasaron!";
                        model.addAttribute("icon", icon);
                        model.addAttribute("titulo", titulo);
                        model.addAttribute("mensaje", mensaje);
                    } else {
                        List<Citas> citasExist = service.listar();
                        LocalDateTime minima = fecha.minusHours(2);
                        LocalDateTime maxima = fecha.plusHours(2);

                        boolean conflicto = citasExist.stream().anyMatch(cita -> (cita.getFecha().isAfter(minima) && cita.getFecha().isBefore(maxima)));
                        if (conflicto) {
                            String icon = "error";
                            String titulo = "Cita cancelada";
                            String mensaje = "¡La hora para la que tratas de registrar tu cita se encuentra en el intervalo de tiempo de una cita que ya fue agendada, intenta con otra hora!";
                            model.addAttribute("icon", icon);
                            model.addAttribute("titulo", titulo);
                            model.addAttribute("mensaje", mensaje);
                        } else {
                            DayOfWeek dia_semana = fecha.getDayOfWeek();
                            int dia = dia_semana.getValue();
                            switch (dia) {
                                case 6, 7:
                                    String icon = "error";
                                    String titulo = "Cita cancelada";
                                    String mensaje = "¡Solo se atiende de lunes a viernes!";
                                    model.addAttribute("icon", icon);
                                    model.addAttribute("titulo", titulo);
                                    model.addAttribute("mensaje", mensaje);
                                    return "modalesCita";
                                default:
                                    int hora = fecha.getHour();
                                    if (hora >= 8 && hora <= 17) {
                                        service.guardar(C);
                                        return "redirect:/vista";
                                    } else {
                                        String icono = "error";
                                        String titulos = "Cita cancelada";
                                        String mensajes = "¡Nuestro horario de atención es de 8 a.m. hasta las 5 p.m!";
                                        model.addAttribute("icon", icono);
                                        model.addAttribute("titulo", titulos);
                                        model.addAttribute("mensaje", mensajes);
                                        return "modalesCita";
                                    }
                            }
                        }
                    }
                }
            } else {
                String icon = "error";
                String titulo = "Cita cancelada";
                String mensaje = "¡Ya hay una cita agendada para esta fecha y hora!";
                model.addAttribute("icon", icon);
                model.addAttribute("titulo", titulo);
                model.addAttribute("mensaje", mensaje);
            }
        } else {
            String icon = "error";
            String titulo = "Cita cancelada";
            String mensaje = "¡Algo ha sucedido, intenta de nuevo!";
            model.addAttribute("icon", icon);
            model.addAttribute("titulo", titulo);
            model.addAttribute("mensaje", mensaje);
        }
        return "modalesCita";
    }


    @GetMapping("/editar/{id}")
    public String editarCita(@PathVariable("id") int id, Model model) {
        Citas cita = service.listaID(id);
        List<Estado> estados = serviceEstado.listar();
        model.addAttribute("estados", estados);
        if (cita != null) {
            model.addAttribute("citaE", cita);
            return "editar";
        } else {
            return "redirect:/vista";
        }
    }

    @PostMapping("/guardarEdicion")
    public String guardarEdicion(@Validated Citas cita, @RequestParam("id") int id, Model model) {
        Citas citaExistente = service.listaID(id);

        if (citaExistente != null) {
            LocalDateTime fecha = cita.getFecha(); // Obtener la fecha de la cita

            if (fecha != null) {
                LocalDateTime fechaActual = LocalDateTime.now();
                LocalDateTime fecha1mes = fechaActual.plusMonths(1);

                if (fecha.isAfter(fecha1mes)) {
                    String icon = "error";
                    String titulo = "Edición de cita cancelada";
                    String mensaje = "¡Solo puedes solicitar citas dentro un rango de tiempo de un mes!";
                    model.addAttribute("icon", icon);
                    model.addAttribute("titulo", titulo);
                    model.addAttribute("mensaje", mensaje);
                } else if (fecha.isBefore(fechaActual)) {
                    String icon = "error";
                    String titulo = "Edición de cita cancelada";
                    String mensaje = "¡La fecha/hora para la cual deseas editar tu cita ya ha pasado!";
                    model.addAttribute("icon", icon);
                    model.addAttribute("titulo", titulo);
                    model.addAttribute("mensaje", mensaje);
                } else {
                    List<Citas> citasExist = service.listar();
                    LocalDateTime minima = fecha.minusHours(2);
                    LocalDateTime maxima = fecha.plusHours(2);

                    boolean hayConflictos = citasExist.stream().anyMatch(c -> (c.getFecha().isAfter(minima) && c.getFecha().isBefore(maxima)));
                    if (hayConflictos) {
                        String icon = "error";
                        String titulo = "Edición de cita cancelada";
                        String mensaje = "¡La hora para la cual tratas de editar tu cita se encuentra en el intervalo de tiempo de una cita que ya esta agendada!";
                        model.addAttribute("icon", icon);
                        model.addAttribute("titulo", titulo);
                        model.addAttribute("mensaje", mensaje);
                    } else {
                        DayOfWeek dia_semana = fecha.getDayOfWeek();
                        int dia = dia_semana.getValue();
                        switch (dia) {
                            case 6,7:
                                String icon = "error";
                                String titulo = "Edición de cita cancelada";
                                String mensaje = "¡Solo se atiende de lunes a viernes!";
                                model.addAttribute("icon", icon);
                                model.addAttribute("titulo", titulo);
                                model.addAttribute("mensaje", mensaje);
                                return "modalesCita";

                            default:
                                int hora = fecha.getHour();
                                if (hora >= 8 && hora <= 17) {
                                    citaExistente.setEstado(cita.getEstado());
                                    citaExistente.setFecha(cita.getFecha());
                                    citaExistente.setObjetivo(cita.getObjetivo());
                                    citaExistente.setNombre_usuario(cita.getNombre_usuario());
                                    service.actualizar(citaExistente);
                                    return "redirect:/vista";
                                } else {
                                    String icono = "error";
                                    String titulos = "Edición de cita cancelada";
                                    String mensajes = "¡La hora para la intentas editar tu cita se encuentra fuera de nuestro horario de atención!";
                                    model.addAttribute("icon", icono);
                                    model.addAttribute("titulo", titulos );
                                    model.addAttribute("mensaje", mensajes);
                                }
                        }
                    }
                }
            }
        }else{
            String icon = "error";
            String titulo = "Edición de cita cancelada";
            String mensaje = "¡Ya hay una cita agendada para este fecha y hora!";
            model.addAttribute("icon", icon);
            model.addAttribute("titulo", titulo);
            model.addAttribute("mensaje", mensaje);
        }
        return "modalesCita";


    }
    /*@PostMapping("/solicitar")
    public String solicitarCita(@Validated Citas C, @RequestParam("fechaStr") String fechaStr, Model model) {
        if (fechaStr != null && !fechaStr.isEmpty()) {
            LocalDateTime fecha = C.convertirFecha();
            C.setFecha(fecha);

            // Obtener la instancia del usuario actual (puedes adaptar esto según tu sistema de autenticación).
            Usuario usuarioSolicitante = obtenerUsuarioActual(); // Debes implementar obtenerUsuarioActual() según tu lógica.

            if (usuarioSolicitante != null) {
                C.setNombre_usuario(usuarioSolicitante.getNombre_completo());

                // Establecer la relación entre la cita y el usuario solicitante.
                C.setId_usuario(usuarioSolicitante);

                // Validar que la fecha de la cita esté dentro del rango permitido.
                LocalDateTime fechaActual = LocalDateTime.now();
                LocalDateTime fecha1mes = fechaActual.plusMonths(1);

                if (fecha.isAfter(fecha1mes)) {
                    String icon = "error";
                    String titulo = "Cita cancelada";
                    String mensaje = "¡Solo puedes solicitar citas dentro de un rango de tiempo de un mes!";
                    model.addAttribute("icon", icon);
                    model.addAttribute("titulo", titulo);
                    model.addAttribute("mensaje", mensaje);
                    return "error"; // Redirigir a la página de error en caso de problemas.
                }

                if (fecha.isBefore(fechaActual)) {
                    String icon = "error";
                    String titulo = "Cita cancelada";
                    String mensaje = "¡La fecha y hora que indicaste ya pasaron!";
                    model.addAttribute("icon", icon);
                    model.addAttribute("titulo", titulo);
                    model.addAttribute("mensaje", mensaje);
                    return "error"; // Redirigir a la página de error en caso de problemas.
                }

                // Resto del código para manejar otras validaciones y redireccionamientos.
                // ...

                // Guardar la cita en la base de datos.
                service.guardar(C);

                return "redirect:/vista"; // Redirigir a la vista de citas u otra página según tu lógica.
            } else {
                // Manejar el caso en el que no se pudo obtener el usuario actual.
                String icon = "error";
                String titulo = "Cita cancelada";
                String mensaje = "¡No se pudo obtener el usuario actual!";
                model.addAttribute("icon", icon);
                model.addAttribute("titulo", titulo);
                model.addAttribute("mensaje", mensaje);
                return "error"; // Redirigir a la página de error en caso de problemas.
            }
        } else {
            // Manejar el caso en el que la fechaStr sea nula o vacía.
            String icon = "error";
            String titulo = "Cita cancelada";
            String mensaje = "¡La fecha y hora son requeridas!";
            model.addAttribute("icon", icon);
            model.addAttribute("titulo", titulo);
            model.addAttribute("mensaje", mensaje);
            return "error"; // Redirigir a la página de error en caso de problemas.
        }
    }

*/
    @GetMapping("/eliminar/{id}")
    public String eliminarCita(@PathVariable("id") int id) {
        service.eliminar(id);
        return "redirect:/vista";
    }

}
