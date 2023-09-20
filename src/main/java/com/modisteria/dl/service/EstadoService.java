package com.modisteria.dl.service;

import com.modisteria.dl.model.Citas;
import com.modisteria.dl.model.Estado;
import com.modisteria.dl.repositorio.EstadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepositorio data;
    public List<Estado> listar() {
        return (List<Estado>)data.findAll();
    }

    public Estado obtenerEstadoPrePorid(int estadoId) {
        return (Estado) data.findById(estadoId).orElse(null);
    }
    public List<Estado> EstadosDisponibles() {
        return data.findAll();
    }


}
