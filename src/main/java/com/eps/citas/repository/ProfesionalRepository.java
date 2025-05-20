package com.eps.citas.repository;

import com.eps.citas.model.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {
    List<Profesional> findByEspecialidad_EspecialidadIdAndSede_SedeId(Long especialidadId, Long sedeId);
}
