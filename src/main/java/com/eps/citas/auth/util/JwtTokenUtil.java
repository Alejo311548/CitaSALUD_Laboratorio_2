package com.eps.citas.auth.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final String SECRET_KEY =
            "clave-secreta-epsclave-secreta-epsclave-secreta-eps"; // ≥32 caracteres
    private static final long EXPIRATION_MS = 1000 * 60 * 60;     // 1 hora

    private Key signingKey;

    @PostConstruct
    public void init() {
        signingKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    /** Genera un JWT con HS256, sujeto = email, expira en 1 hora */
    public String generateToken(String email) {
        Date now    = new Date();
        Date expiry = new Date(now.getTime() + EXPIRATION_MS);

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(signingKey)   // HS256 detectado automáticamente
                .compact();
    }

    /** Extrae el campo 'subject' (el email) del token */
    public String extractUsername(String token) {
        return parseClaims(token).getSubject();
    }

    /** Valida firma y expiración */
    public boolean validateToken(String token) {
        try {
            Jws<Claims> jws = Jwts.parser()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(token);
            return !jws.getBody().getExpiration().before(new Date());
        } catch (Exception ex) {
            return false;
        }
    }

    /** Parsea y verifica la firma, devolviendo los Claims */
    private Claims parseClaims(String token) {
        Jws<Claims> jws = Jwts.parser()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token);
        return jws.getBody();
    }
}
