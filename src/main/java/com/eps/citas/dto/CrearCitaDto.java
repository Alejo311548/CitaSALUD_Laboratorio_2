package com.eps.citas.dto;

import java.time.LocalDateTime;

public class CrearCitaDto {
    private Long profesionalId;
    private Long sedeId;
    private LocalDateTime fechaHora;

    // Constructor vacío
    public CrearCitaDto() {
    }

    // Getters y setters

    public Long getProfesionalId() {
        return profesionalId;
    }

    public void setProfesionalId(Long profesionalId) {
        this.profesionalId = profesionalId;
    }

    public Long getSedeId() {
        return sedeId;
    }

    public void setSedeId(Long sedeId) {
        this.sedeId = sedeId;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}
