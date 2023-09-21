package com.modisteria.dl.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Estados")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nombre_estado;
    @OneToMany(mappedBy = "estado") // Relación "uno a muchos" con Permiso
    private List<Permiso> permisos;



    public Estado(){}
    public Estado (int id, String nombre_estado){
        this.id =id;
        this.nombre_estado=nombre_estado;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNombre_estado() {return nombre_estado;}

    public void setNombre_estado(String nombre_estado) {
    	this.nombre_estado = nombre_estado;
    }
}
