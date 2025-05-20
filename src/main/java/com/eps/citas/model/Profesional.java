package com.eps.citas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "profesionales")
public class Profesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profesionalId;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", nullable = false)
    private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "sede_id", nullable = false)
    private Sede sede;

    // Constructor vacío
    public Profesional() {
    }

    // Constructor con todos los campos
    public Profesional(Long profesionalId, String nombre, Especialidad especialidad, Sede sede) {
        this.profesionalId = profesionalId;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.sede = sede;
    }

    // Constructor solo con ID
    public Profesional(Long profesionalId) {
        this.profesionalId = profesionalId;
    }

    // Getters y setters

    public Long getProfesionalId() {
        return profesionalId;
    }

    public void setProfesionalId(Long profesionalId) {
        this.profesionalId = profesionalId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
}
