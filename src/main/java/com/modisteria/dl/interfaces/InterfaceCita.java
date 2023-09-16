package com.modisteria.dl.interfaces;

import org.springframework.data.repository.CrudRepository;
import com.modisteria.dl.model.Citas;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceCita extends CrudRepository<Citas, Integer> {

}
