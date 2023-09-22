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

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = true)
    private Estado estado;

    @Column(nullable = false)
    private String nombre_usuario;

    @Column(nullable = false)
    private String imagen;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = true)
    private Usuario id_usuario;

    public Citas() {

    }

    public Citas(int id, LocalDateTime fecha, String objetivo

            , String nombre_usuario, String imagen, Usuario id_usuario) {
        this.id = id;
        this.fecha = fecha;
        this.objetivo = objetivo;
        this.nombre_usuario = nombre_usuario;
        this.imagen = imagen;
        this.id_usuario = id_usuario;
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
    public String getNombre_usuario() {
        return nombre_usuario;
    }
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
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
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public LocalDateTime convertirFecha() {
        if (fechaStr != null && !fechaStr.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            return LocalDateTime.parse(fechaStr, formatter);
        } else {
            System.out.println("El valor de fechaStr es nulo o vacío.");
            return null;
        }
    }



}
