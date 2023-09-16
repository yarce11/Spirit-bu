package com.modisteria.dl.interface_service;

import com.modisteria.dl.model.Citas;

import java.util.List;

public interface Interface_cita_service {
    public List<Citas>listar();
    public List<Citas>listaID(Integer id);
    public int guardar(Citas C);
    public void eliminar(Integer id);
}
