package com.modisteria.dl.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="citas")
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Transient
    private String fechaStr;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private String objetivo;

    @Column(nullable = true)
    private String estado;

    @Column(nullable = false)
    private String usuario;

    @Column(nullable = true)
    private String imagen;
    @Column(nullable = true)
    private LocalDateTime hora_a;
    @Column(nullable = true)
    private LocalDateTime hora_d;

    public Citas() {

    }

    public Citas(int id, LocalDateTime fecha, String objetivo

            , String usuario, String imagen) {
        this.id = id;
        this.fecha = fecha;
        this.objetivo = objetivo;
        this.usuario = usuario;
        this.imagen = imagen;
    }


    public int getId() {return id;}
    public void setId(int id) {
        this.id = id;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public String  getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(String objetivo) {this.objetivo = objetivo;}
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public String getFechaStr() {
        return fechaStr;
    }
    public void setFechaStr(String fechaStr) {
        this.fechaStr = fechaStr;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public LocalDateTime getHora_a() {return hora_a;}
    public void setHora_a(LocalDateTime hora_a) {this.hora_a = hora_a;}
    public LocalDateTime getHora_d() {return hora_d;}
    public void setHora_d(LocalDateTime hora_d) {this.hora_d = hora_d;}
    public LocalDateTime convertirFecha() {
        if (fechaStr != null && !fechaStr.isEmpty()) { // Verificar si fechaStr no es nulo ni vacío
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            return LocalDateTime.parse(fechaStr, formatter);
        } else {
            System.out.println("El valor de fechaStr es nulo o vacío.");
            return null; // Manejar el caso en que fechaStr sea nulo o vacío
        }
    }
    @PrePersist
    public void prePersist() {
        if (estado == null) {
            estado = "Pendiente";
        }
    }

}
