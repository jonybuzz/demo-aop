package com.demo.demoaop.controller.rest;

import com.demo.demoaop.dominio.Persona;
import com.demo.demoaop.dominio.Personas;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaRestController {

    @Autowired
    private Personas personas;

    @GetMapping("/personas")
    public List<Persona> obtenerTodasLasPersonas() {
        return personas.getPersonas();
    }

    @PostMapping("/personas/{numero}/edad")
    public String cambiarEdad(@PathVariable Integer numero, @RequestParam Integer edad) {
        Persona persona = personas.getPersonas().get(numero);
        persona.setEdad(edad);
        return "OK";
        
    }

}
