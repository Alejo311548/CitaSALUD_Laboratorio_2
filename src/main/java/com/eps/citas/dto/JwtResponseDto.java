package com.eps.citas.dto;

public class JwtResponseDto {
    private String token;

    public JwtResponseDto(String token) {
        this.token = token;
    }

    // Getter
    public String getToken() {
        return token;
    }
}

