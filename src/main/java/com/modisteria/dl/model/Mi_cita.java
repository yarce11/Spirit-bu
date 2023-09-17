package com.modisteria.dl.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="mi_cita")
public class Mi_cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_micita;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private int id_cita;

    @ManyToMany(mappedBy = "miCitas")
    private List<Insumos> insumos;

    public Mi_cita(){

    }
    public Mi_cita(int id_micita, String estado, int id_cita){
        this.id_micita = id_micita;
        this.estado=estado;
        this.id_cita=id_cita;
    }
    public int getId_micita() {
        return id_micita;
    }
    public void setId_micita(int id_micita) {
        this.id_micita = id_micita;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getId_cita() {
        return id_cita;
    }
    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public List<Insumos> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<Insumos> insumos) {
        this.insumos = insumos;
    }
}
