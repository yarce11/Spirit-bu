package com.modisteria.dl.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "insumos")
public class Insumos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_insumos;

    @Column(nullable = false)
    private String nombre_insumo;

    @Column(nullable = false)
    private float metraje;

    @ManyToMany
    @JoinTable(
            name = "insumos_mi_cita",
            joinColumns = @JoinColumn(name = "id_insumos"),
            inverseJoinColumns = @JoinColumn(name = "id_micita")
    )
    private Set<Mi_cita> miCitas = new HashSet<>();

    @Column(nullable = false)
    private int id_carrito;

    public Insumos() {
    }

    public Insumos(int id_insumos, String nombre_insumo, float metraje, int id_carrito) {
        this.id_insumos = id_insumos;
        this.nombre_insumo = nombre_insumo;
        this.metraje = metraje;
        this.id_carrito = id_carrito;
    }

    public int getId_insumos() {
        return id_insumos;
    }

    public void setId_insumos(int id_insumos) {
        this.id_insumos = id_insumos;
    }

    public String getNombre_insumo() {
        return nombre_insumo;
    }

    public void setNombre_insumo(String nombre_insumo) {
        this.nombre_insumo = nombre_insumo;
    }

    public float getMetraje() {
        return metraje;
    }

    public void setMetraje(float metraje) {
        this.metraje = metraje;
    }

    public Set<Mi_cita> getMiCitas() {
        return miCitas;
    }

    public void setMiCitas(Set<Mi_cita> miCitas) {
        this.miCitas = miCitas;
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }
}
