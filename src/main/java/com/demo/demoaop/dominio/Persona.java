package com.demo.demoaop.dominio;

public class Persona {

    private String nombre;
    private Integer edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " / Edad: " + this.edad;
    }

}
