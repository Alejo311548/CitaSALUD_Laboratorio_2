package com.eps.citas.dto;



public class CancelarCitaDto {
    private String motivoCancelacion;
    private Long motivoId;

    // getters y setters
    public String getMotivoCancelacion() {
        return motivoCancelacion;
    }
    public void setMotivoCancelacion(String motivoCancelacion) {
        this.motivoCancelacion = motivoCancelacion;
    }

    public Long getMotivoId() {
        return motivoId;
    }
    public void setMotivoId(Long motivoId) {
        this.motivoId = motivoId;
    }
}

