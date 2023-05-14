package com.porfolio.yp.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    
    private String tiempo;
    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombre, String descripcion, String tiempo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
    }
    //Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombreE(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcionE(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    
    
}

