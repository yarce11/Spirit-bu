
package com.modisteria.dl.dto;

public class UsuarioRegistroDTO {
    private Long id;
    private String nombre_completo;
    private String correo;
    private String telefono;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioRegistroDTO(Long id, String nombre_completo, String correo, String telefono, String password) {
        this.id = id;
        this.nombre_completo = nombre_completo;
        this.correo = correo;
        this.telefono = telefono;
        this.password = password;
    }

    public UsuarioRegistroDTO(String nombre_completo, String correo, String telefono, String password) {
        this.nombre_completo = nombre_completo;
        this.correo = correo;
        this.telefono = telefono;
        this.password = password;
    }

    public UsuarioRegistroDTO(String correo) {
        this.correo = correo;
    }

    public UsuarioRegistroDTO() {
    }
    
 }
