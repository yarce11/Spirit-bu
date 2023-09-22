package com.modisteria.dl.repositorio;

import com.modisteria.dl.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepositorio extends JpaRepository<Estado, Integer> {
}