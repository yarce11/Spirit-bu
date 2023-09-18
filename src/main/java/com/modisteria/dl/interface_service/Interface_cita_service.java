package com.modisteria.dl.interface_service;

import com.modisteria.dl.model.Citas;

import java.util.List;

public interface Interface_cita_service {
    public List<Citas>listar();
    public int guardar(Citas C);
    public Citas listaID(int id);
    public Citas actualizar(Citas citas);

    public void eliminar(int id);
}
