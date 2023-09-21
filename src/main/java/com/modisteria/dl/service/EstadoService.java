package com.modisteria.dl.service;

import com.modisteria.dl.model.Estado;
import com.modisteria.dl.repositorio.EstadoRepositorio;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    @Autowired
	private EstadoRepositorio data;
	
    
	public List<Estado> listar() {
		return (List<Estado>) data.findAll();
	}

    
    public int guardar(Estado e) {
		int res = 0; 
		Estado estado = data.save(e);
		if (!estado.equals(null)) {
			res = 1;
		}
		return res;
	}

    public Estado obtenerEstadoPrePorid(int estadoId) {
        return (Estado) data.findById(estadoId).orElse(null);
    }
    public List<Estado> EstadosDisponibles() {
        return data.findAll();
    }

	public Optional<Estado> listarId(int id) {
		return data.findById(id);
	}

	public void delete(int id) {
		data.deleteById(id);
	}
	
	/*public Estado listarId(int id) {
		return data.findById(id).get();
	}

	public Estado actualizar(Estado estados) {
        return data.save(estados);
    }*/


}
