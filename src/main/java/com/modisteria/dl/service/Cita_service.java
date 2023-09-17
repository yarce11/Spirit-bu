package com.modisteria.dl.service;

import com.modisteria.dl.interface_service.Interface_cita_service;
import com.modisteria.dl.interfaces.InterfaceCita;
import com.modisteria.dl.model.Citas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Agrega la anotación @Service para que Spring reconozca esta clase como un bean
public class Cita_service implements Interface_cita_service {
    @Autowired
    private InterfaceCita data;
    @Override
    public List<Citas> listar() {
        return (List<Citas>)data.findAll();
    }
    @Override
    public Optional<Citas> listaID(Integer id) {
        return data.findById(id);
    }
    @Override
    public int guardar(Citas C) {
        int res=0;
        Citas cita =data.save(C);
        if (!cita.equals(null)){
            res=1;
        }
        return 0;
    }
    @Override
    public void eliminar(Integer id) {

    }
}
