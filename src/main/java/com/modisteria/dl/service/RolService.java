package com.modisteria.dl.service;

import com.modisteria.dl.model.Permiso;
import com.modisteria.dl.model.Rol;
import com.modisteria.dl.repositorio.PermisoRepositorio;
import com.modisteria.dl.repositorio.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolRepositorio data;

    public List<Rol> listar() {
        return (List<Rol>)data.findAll();
    }

    public int guardar(Rol r) {
		int res = 0;
		Rol rol = data.save(r);
		if (!rol.equals(null)) {
			res = 1;
		}
		return res;
	}


	public Optional<Rol> listarId(Long id) {
		return data.findById(id);
	}

	public void delete(Long id) {
		data.deleteById(id);
	}




}
