package com.eps.citas.controller;

import com.eps.citas.model.Sede;
import com.eps.citas.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sedes")

public class SedeController {

    @Autowired
    private SedeRepository repository;

    @PostMapping
    public Sede crear(@RequestBody Sede sede) {
        return repository.save(sede);
    }

    @GetMapping
    public List<Sede> obtenerTodas() {
        return repository.findAll();
    }
}
