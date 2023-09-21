package com.modisteria.dl.service;

import com.modisteria.dl.model.Permiso;
import com.modisteria.dl.repositorio.PermisoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisoService {
    @Autowired
    private PermisoRepositorio data;

    public List<Permiso> listar() {
        return (List<Permiso>)data.findAll();
    }

    public int guardar(Permiso p) {
		int res = 0;
		Permiso permiso = data.save(p);
		if (!permiso.equals(null)) {
			res = 1;
		}
		return res;
	}


	public Optional<Permiso> listarId(int id) {
		return data.findById(id);
	}

	public void delete(int id) {
		data.deleteById(id);
	}




}
