package com.modisteria.dl.repositorio;

import com.modisteria.dl.model.Estado;
import com.modisteria.dl.model.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepositorio extends JpaRepository<Permiso, Integer> {
}
