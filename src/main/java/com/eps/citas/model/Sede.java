package com.eps.citas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sedes")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sedeId;

    private String nombre;
    private String direccion;
    private String telefono;

    // Constructor vacío
    public Sede() {
    }

    // Constructor con todos los campos
    public Sede(Long sedeId, String nombre, String direccion, String telefono) {
        this.sedeId = sedeId;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Constructor solo con ID
    public Sede(Long sedeId) {
        this.sedeId = sedeId;
    }

    // Getters y setters

    public Long getSedeId() {
        return sedeId;
    }

    public void setSedeId(Long sedeId) {
        this.sedeId = sedeId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
