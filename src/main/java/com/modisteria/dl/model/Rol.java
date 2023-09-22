package com.modisteria.dl.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Rol")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    // Elimina la relación @OneToMany que se refiere a Permiso
    // @OneToMany(mappedBy = "rol")
    // private List<Permiso> permisos;

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

    public Rol(long id) {
        this.id = id;
    }

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    public Rol() {
    }

    public Rol(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
