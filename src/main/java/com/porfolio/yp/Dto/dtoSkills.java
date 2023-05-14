package com.porfolio.yp.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSkills {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private int valor;

    public dtoSkills(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.valor = porcentaje;
    }

    public dtoSkills() {
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}

