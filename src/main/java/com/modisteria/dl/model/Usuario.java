package com.modisteria.dl.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name="nombre_completo",nullable = false)
    private String nombre_completo;

    @Column(name="correo",nullable = false)
    private String correo;

    @Column(name="telefono",nullable = false)
    private String telefono;

    @Column(name="contraseña",nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = true)
    private Rol rol;


    //Getters
    public String getNombre_completo() {
        return nombre_completo;
    }
    public String getCorreo() {
        return correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getPassword() {
        return password;
    }
    public Long getId() {
        return id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Usuario(Long id, String nombre_completo, String correo, String telefono, String password) {
        super();
        this.id = id;
        this.nombre_completo = nombre_completo;
        this.correo = correo;
        this.telefono = telefono;
        this.password = password;
    }

    public Usuario(String nombre_completo, String correo, String telefono, String password) {
        super();
        this.nombre_completo = nombre_completo;
        this.correo = correo;
        this.telefono = telefono;
        this.password = password;
    }
    public Usuario() {
        super();
    }

    public Usuario(Long id, String nombre_completo, String correo, String telefono, String password, Rol rol) {
        this.id = id;
        this.nombre_completo = nombre_completo;
        this.correo = correo;
        this.telefono = telefono;
        this.password = password;
        this.rol = rol;
    }

    public Usuario(String nombre_completo, String correo, String telefono, String password, Rol rol) {
        this.nombre_completo = nombre_completo;
        this.correo = correo;
        this.telefono = telefono;
        this.password = password;
        this.rol = rol;
    }


}
