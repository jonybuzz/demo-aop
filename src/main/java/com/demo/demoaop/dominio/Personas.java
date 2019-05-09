package com.demo.demoaop.dominio;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Personas {

    private List<Persona> personas;

    public Personas() {
        this.personas = new ArrayList<>();
        Persona juan = new Persona();
        juan.setNombre("Juan");
        juan.setEdad(25);
        Persona marta = new Persona();
        marta.setNombre("Marta");
        marta.setEdad(32);
        this.personas.add(juan);
        this.personas.add(marta);
    }

    public List<Persona> getPersonas() {
        return personas;
    }

}
