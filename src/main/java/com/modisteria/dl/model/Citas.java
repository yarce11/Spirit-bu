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
    private String usuario;

    @Column(nullable = false)
    private String imagen;


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
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDateTime convertirFecha() {
        if (fechaStr != null && !fechaStr.isEmpty()) { // Verificar si fechaStr no es nulo ni vacío
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            return LocalDateTime.parse(fechaStr, formatter);
        } else {
            System.out.println("El valor de fechaStr es nulo o vacío.");
            return null; // Manejar el caso en que fechaStr sea nulo o vacío
        }
    }


}
