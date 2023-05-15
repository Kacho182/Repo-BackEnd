
package com.porfolio.yp.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    
@NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    
    private String tiempo;
    
    private String img;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombre, String descripcion, String tiempo, String img) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    
    
    
}

