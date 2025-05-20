package com.eps.citas.dto;

import java.time.LocalDateTime;

public class SlotDisponibleDto {
    private LocalDateTime inicio;
    private LocalDateTime fin;

    // Constructor con todos los campos
    public SlotDisponibleDto(LocalDateTime inicio, LocalDateTime fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    // Getters y setters

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }
}
