package com.eps.citas.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "disponibilidad_profesionales")
public class DisponibilidadProfesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long disponibilidadId;

    @ManyToOne
    @JoinColumn(name = "profesional_id", nullable = false)
    private Profesional profesional;

    @Column(name = "dia_semana", nullable = false)
    private String diaSemana;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    // Constructor vacío
    public DisponibilidadProfesional() {
    }

    // Constructor con todos los campos
    public DisponibilidadProfesional(Long disponibilidadId, Profesional profesional, String diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        this.disponibilidadId = disponibilidadId;
        this.profesional = profesional;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    // Getters y setters

    public Long getDisponibilidadId() {
        return disponibilidadId;
    }

    public void setDisponibilidadId(Long disponibilidadId) {
        this.disponibilidadId = disponibilidadId;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
}
