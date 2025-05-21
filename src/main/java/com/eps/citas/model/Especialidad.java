package com.eps.citas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "especialidades")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long especialidadId;

    private String nombre;

    // Constructor vacío obligatorio para Jackson y JPA
    public Especialidad() {
    }

    // Constructor con todos los campos
    public Especialidad(Long especialidadId, String nombre) {
        this.especialidadId = especialidadId;
        this.nombre = nombre;
    }

    // Constructor solo con ID. Debo revisar los constructores
    public Especialidad(Long especialidadId) {
        this.especialidadId = especialidadId;
    }

    // Getters y setters públicos

    public Long getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(Long especialidadId) {
        this.especialidadId = especialidadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
