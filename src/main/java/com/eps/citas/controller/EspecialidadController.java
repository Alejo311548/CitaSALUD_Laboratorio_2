package com.eps.citas.controller;

import com.eps.citas.model.Especialidad;
import com.eps.citas.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")

public class EspecialidadController {

    @Autowired
    private EspecialidadRepository repository;

    @PostMapping
    public Especialidad crear(@RequestBody Especialidad especialidad) {
        return repository.save(especialidad);
    }

    @GetMapping
    public List<Especialidad> obtenerTodas() {
        return repository.findAll();
    }
}
