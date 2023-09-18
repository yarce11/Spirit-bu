package com.modisteria.dl.model;

import java.util.HashSet;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Roles" )
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Rol")
    private Long id;
    @Column(name = "Nombre")
    private String nombre;

    @ManyToMany
    @JoinTable(name = "Permisos_Rol",
    joinColumns = @JoinColumn(name="Rol_id"),
    inverseJoinColumns = @JoinColumn(name = "permiso_id"))
    private Set<Permiso> permisos = new HashSet<>();


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

    public Set<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }



    public Rol(String nombre, Set<Permiso> permiso) {
        this.nombre = nombre;
        this.permisos = permiso;
    }

    public Rol() {
    }

    public Rol(Long id, String nombre, Set<Permiso> permiso) {
        this.id = id;
        this.nombre = nombre;
        this.permisos = permiso;
    }
    
}
