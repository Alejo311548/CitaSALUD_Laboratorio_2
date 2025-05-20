package com.eps.citas.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "motivos_cancelacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotivoCancelacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long motivoId;

    private String descripcion;
}

