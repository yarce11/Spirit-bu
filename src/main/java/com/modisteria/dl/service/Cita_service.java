package com.modisteria.dl.service;

import com.modisteria.dl.interface_service.Interface_cita_service;
import com.modisteria.dl.interfaces.InterfaceCita;
import com.modisteria.dl.model.Citas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Agrega la anotación @Service para que Spring reconozca esta clase como un bean
public class Cita_service implements Interface_cita_service {
    @Autowired
    private InterfaceCita data;
    @Override
    public List<Citas> listar() {
        return (List<Citas>)data.findAll();
    }
    @Override
    public int guardar(Citas C) {
        int res = 0;
        Citas cita = data.save(C);
        if (cita != null) {
            res = 1;
        }
        return res;
    }
    @Override
    public Citas listaID(int id) {
        return data.findById(id).get();
    }

    @Override
    public Citas actualizar(Citas citas) {
        return data.save(citas);
    }
    @Override
    public void eliminar(int id) {
        data.deleteById(id);
    }
}
