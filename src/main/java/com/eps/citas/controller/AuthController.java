package com.eps.citas.controller;

import com.eps.citas.dto.JwtResponseDto;
import com.eps.citas.dto.RegistroUsuarioDto;
import com.eps.citas.model.Usuario;
import com.eps.citas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.eps.citas.dto.LoginDto;
import com.eps.citas.auth.util.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UserDetails;


import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginRequest) {
        try {
            // 1. Autenticar
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );

            // 2. Obtener userDetails desde el objeto autenticado
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // 3. Generar token
            String token = jwtUtil.generateToken(userDetails.getUsername());

            // 4. Devolver token
            return ResponseEntity.ok(new JwtResponseDto(token));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegistroUsuarioDto dto) {
        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email ya registrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefono(dto.getTelefono());
        usuario.setRol("PACIENTE");
        usuario.setPasswordHash(passwordEncoder.encode(dto.getPassword()));
        usuarioRepository.save(usuario);

        return ResponseEntity.ok("Registro exitoso.");
    }

    @PostMapping("/register/profesional")
    public ResponseEntity<?> registerProfesional(@RequestBody @Valid RegistroUsuarioDto dto) {
        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email ya registrado.");
        }

        Usuario profesional = new Usuario();
        profesional.setNombre(dto.getNombre());
        profesional.setEmail(dto.getEmail());
        profesional.setTelefono(dto.getTelefono());
        profesional.setRol("PROFESIONAL");
        profesional.setPasswordHash(passwordEncoder.encode(dto.getPassword()));
        usuarioRepository.save(profesional);

        return ResponseEntity.ok("Profesional registrado exitosamente.");
    }



}
