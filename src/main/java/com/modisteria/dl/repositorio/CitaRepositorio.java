package com.modisteria.dl.repositorio;

import org.springframework.data.repository.CrudRepository;
import com.modisteria.dl.model.Citas;
import com.modisteria.dl.model.Usuario;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepositorio extends CrudRepository<Citas, Integer> {
    List<Citas> findByFecha(LocalDateTime fecha);
    void deleteById(Long id);

    Usuario findById(Long id);

}