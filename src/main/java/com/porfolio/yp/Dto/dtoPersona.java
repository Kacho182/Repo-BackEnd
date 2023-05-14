package com.porfolio.yp.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPersona {
    
@NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String imgperfil;
    @NotBlank
    private String imgbaner;
    @NotBlank
    private String acercade;
    
    private String ubicacion;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String descripcion, String imgperfil, String imgbaner, String acercade, String ubicacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.acercade = acercade;
        this.imgperfil = imgperfil;
        this.imgbaner =imgbaner;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImgperfil() {
        return imgperfil;
    }

    public void setImgperfil(String imgperfil) {
        this.imgperfil = imgperfil;
    }

    public String getImgbaner() {
        return imgbaner;
    }

    public void setImgbaner(String imgbaner) {
        this.imgbaner = imgbaner;
    }

    public String getAcercade() {
        return acercade;
    }

    public void setAcercade(String acercade) {
        this.acercade = acercade;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
}

