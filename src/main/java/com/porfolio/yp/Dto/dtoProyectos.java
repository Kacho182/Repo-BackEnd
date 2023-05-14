
package com.porfolio.yp.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyectos {
    
@NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String url;

    public dtoProyectos() {
    }

    public dtoProyectos(String nombre, String descripcion, String url) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}

