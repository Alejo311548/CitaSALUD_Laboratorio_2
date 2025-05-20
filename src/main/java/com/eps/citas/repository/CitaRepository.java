package com.eps.citas.repository;

import com.eps.citas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    boolean existsByProfesional_ProfesionalIdAndFechaHora(Long profesionalId, LocalDateTime fechaHora);

    // Método para obtener citas por usuarioId
    List<Cita> findByUsuario_UsuarioId(Long usuarioId);
}
