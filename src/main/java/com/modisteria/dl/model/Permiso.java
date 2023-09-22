package com.modisteria.dl.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Permisos")
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_permiso")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "Id_Rol")
    private Rol rol;
    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Permiso(Long id, String nombre, String descripcion, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rol = rol;
    }

    public Permiso() {
    }

    public Permiso(String nombre, String descripcion, Rol rol) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rol = rol;
    }
}


