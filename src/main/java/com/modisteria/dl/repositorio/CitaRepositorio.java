package com.modisteria.dl.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.modisteria.dl.model.Citas;
import com.modisteria.dl.model.Usuario;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepositorio extends CrudRepository<Citas, Integer> {
    List<Citas> findByFecha(LocalDateTime fecha);
    @Query("SELECT c FROM Citas c WHERE DATE(c.fecha) = CURRENT_DATE")
    List<Citas> obtenerCitasDelDia();

    @Query("SELECT c FROM Citas c WHERE DATE(c.fecha) = DATE(:tomorrowDate)")
    List<Citas> obtenerCitasDeManana(@Param("tomorrowDate") LocalDate tomorrowDate);




}
