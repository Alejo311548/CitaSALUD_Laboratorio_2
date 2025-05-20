package com.eps.citas.controller;

import com.eps.citas.model.Especialidad;
import com.eps.citas.model.Profesional;
import com.eps.citas.model.Sede;
import com.eps.citas.repository.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/profesionales")
public class ProfesionalController {

    private final ProfesionalRepository profesionalRepository;

    @Autowired
    public ProfesionalController(ProfesionalRepository profesionalRepository) {
        this.profesionalRepository = profesionalRepository;
    }

    @GetMapping
    public List<Profesional> listarTodos() {
        return profesionalRepository.findAll();
    }

    @GetMapping("/filtrar")
    public List<Profesional> filtrarPorEspecialidadYSede(
            @RequestParam Long especialidadId,
            @RequestParam Long sedeId) {

        return profesionalRepository
                .findByEspecialidad_EspecialidadIdAndSede_SedeId(especialidadId, sedeId);
    }

    @PostMapping
    public ResponseEntity<Profesional> crearProfesional(
            @RequestParam String nombre,
            @RequestParam Long especialidadId,
            @RequestParam Long sedeId) {

        Especialidad especialidad = new Especialidad(especialidadId);
        Sede sede = new Sede(sedeId);

        Profesional profesional = new Profesional();
        profesional.setNombre(nombre);
        profesional.setEspecialidad(especialidad);
        profesional.setSede(sede);

        Profesional guardado = profesionalRepository.save(profesional);
        return ResponseEntity.ok(guardado);
    }

}
