package com.modisteria.dl.interface_service;

import com.modisteria.dl.model.Citas;

import java.util.List;
import java.util.Optional;

public interface Interface_cita_service {
    public List<Citas>listar();
    public Optional<Citas> listaID(Integer id);
    public int guardar(Citas C);
    public void eliminar(Integer id);
}
