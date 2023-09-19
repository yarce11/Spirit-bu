package com.modisteria.dl.service;

import com.modisteria.dl.repositorio.CitaRepositorio;
import com.modisteria.dl.model.Citas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Agrega la anotación @Service para que Spring reconozca esta clase como un bean
public class Cita_service{
    @Autowired
    private CitaRepositorio data;

    public List<Citas> listar() {
        return (List<Citas>)data.findAll();
    }

    public int guardar(Citas C) {
        int res = 0;
        Citas cita = data.save(C);
        if (cita != null) {
            res = 1;
        }
        return res;
    }

    public Citas listaID(int id) {
        return data.findById(id).get();
    }


    public Citas actualizar(Citas citas) {
        return data.save(citas);
    }

    public void eliminar(int id) {
        data.deleteById(id);
    }

    public boolean verificarFecha(Citas nuevaCita){
        List<Citas>citaExistente = data.findByFecha(nuevaCita.getFecha());
        return citaExistente.isEmpty(); //IsEmpty() me devuelve una respuesta boolean dependediendo del caso de citaExistente
    }




}
