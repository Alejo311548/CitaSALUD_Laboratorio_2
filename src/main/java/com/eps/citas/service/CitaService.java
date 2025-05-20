package com.eps.citas.service;

import com.eps.citas.dto.CrearCitaDto;
import com.eps.citas.dto.SlotDisponibleDto;
import com.eps.citas.model.Cita;
import com.eps.citas.model.DisponibilidadProfesional;
import com.eps.citas.model.Profesional;
import com.eps.citas.model.Sede;
import com.eps.citas.model.Usuario;
import com.eps.citas.repository.CitaRepository;
import com.eps.citas.repository.DisponibilidadRepository;
import com.eps.citas.repository.UsuarioRepository;
import com.eps.citas.repository.ProfesionalRepository;
import com.eps.citas.repository.SedeRepository;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CitaService {

    private final CitaRepository citaRepository;
    private final ProfesionalRepository profesionalRepository;
    private final DisponibilidadRepository disponibilidadRepository;
    private final UsuarioRepository usuarioRepository;
    private final SedeRepository sedeRepository;

    public CitaService(CitaRepository citaRepository,
                       ProfesionalRepository profesionalRepository,
                       DisponibilidadRepository disponibilidadRepository,
                       UsuarioRepository usuarioRepository,
                       SedeRepository sedeRepository) {
        this.citaRepository = citaRepository;
        this.profesionalRepository = profesionalRepository;
        this.disponibilidadRepository = disponibilidadRepository;
        this.usuarioRepository = usuarioRepository;
        this.sedeRepository = sedeRepository;
    }

    public List<SlotDisponibleDto> obtenerDisponibilidad(Long profesionalId, LocalDate fecha) {
        List<DisponibilidadProfesional> disponibilidad =
                disponibilidadRepository.findByProfesional_ProfesionalId(profesionalId);

        DayOfWeek dia = fecha.getDayOfWeek();

        return disponibilidad.stream()
                .filter(d -> d.getDiaSemana().equalsIgnoreCase(dia.name()))
                .flatMap(d -> {
                    List<SlotDisponibleDto> slots = new ArrayList<>();
                    LocalTime start = d.getHoraInicio();
                    LocalTime end = d.getHoraFin();

                    while (start.plusMinutes(30).isBefore(end) || start.plusMinutes(30).equals(end)) {
                        LocalDateTime slotInicio = LocalDateTime.of(fecha, start);
                        if (!citaRepository.existsByProfesional_ProfesionalIdAndFechaHora(profesionalId, slotInicio)) {
                            slots.add(new SlotDisponibleDto(slotInicio, slotInicio.plusMinutes(30)));
                        }
                        start = start.plusMinutes(30);
                    }
                    return slots.stream();
                }).toList();
    }

    public void agendarCita(String emailUsuario, CrearCitaDto dto) {
        Usuario usuario = usuarioRepository.findByEmail(emailUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (citaRepository.existsByProfesional_ProfesionalIdAndFechaHora(dto.getProfesionalId(), dto.getFechaHora())) {
            throw new IllegalArgumentException("Ese horario ya está ocupado");
        }

        Cita cita = new Cita();

        Profesional profesional = profesionalRepository.findById(dto.getProfesionalId())
                .orElseThrow(() -> new RuntimeException("Profesional no encontrado"));

        Sede sede = sedeRepository.findById(dto.getSedeId())
                .orElseThrow(() -> new RuntimeException("Sede no encontrada"));

        cita.setUsuario(usuario);
        cita.setProfesional(profesional);
        cita.setSede(sede);
        cita.setFechaHora(dto.getFechaHora());
        cita.setEstado("AGENDADA");

        citaRepository.save(cita);
    }

    // NUEVO: Obtener citas por usuario (email)
    public List<Cita> obtenerCitasPorUsuario(String emailUsuario) {
        Usuario usuario = usuarioRepository.findByEmail(emailUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return citaRepository.findByUsuario_UsuarioId(usuario.getUsuarioId());
    }
}
