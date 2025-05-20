package com.eps.citas.dto;


public class LoginDto {
    private String email;
    private String password;

    // Constructor vacío
    public LoginDto() {
    }

    // Constructor con parámetros
    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getter y Setter para email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter y Setter para password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Método toString
    @Override
    public String toString() {
        return "LoginDto{" +
                "email='" + email + '\'' +
                ", password='[PROTECTED]'}";
    }
}

