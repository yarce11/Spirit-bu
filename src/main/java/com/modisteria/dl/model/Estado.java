package com.modisteria.dl.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Estados")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre_estado;
    @OneToOne(mappedBy = "estado")
    private Permiso permiso;

    public Estado(){}

    public Estado (String nombre_estado){
        this.nombre_estado=nombre_estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_estado() {
        return nombre_estado;
    }

    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }
}
