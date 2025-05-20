package com.eps.citas.repository;

import com.eps.citas.model.DisponibilidadProfesional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DisponibilidadRepository extends JpaRepository<DisponibilidadProfesional, Long> {
    List<DisponibilidadProfesional> findByProfesional_ProfesionalId(Long profesionalId);

}
