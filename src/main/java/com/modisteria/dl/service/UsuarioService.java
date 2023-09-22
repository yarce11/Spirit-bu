package com.modisteria.dl.service;


import org.springframework.stereotype.Service;

import com.modisteria.dl.model.Rol;
import com.modisteria.dl.model.Usuario;
import com.modisteria.dl.repositorio.RolRepositorio;
import com.modisteria.dl.repositorio.UsuarioRepositorio;

@Service
public class UsuarioService {

    private final UsuarioRepositorio usuarioRepositorio;
    private final RolRepositorio rolRepositorio;

    public UsuarioService(UsuarioRepositorio usuarioRepositorio, RolRepositorio rolRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.rolRepositorio = rolRepositorio;
    }

    public void guardarUsuario(Usuario usuario) {
        Rol primerRol = rolRepositorio.findById(1L).orElse(null); // Cambia 1L al ID del primer rol
        usuario.setRol(primerRol); // Asigna el primer rol
        usuarioRepositorio.save(usuario);
    }


}
