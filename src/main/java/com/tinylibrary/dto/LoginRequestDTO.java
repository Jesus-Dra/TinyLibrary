package com.tinylibrary.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequestDTO {

    @Email
    @Size(min = 4)
    @NotBlank
    private String correo;

    @Size(min = 4)
    @NotBlank
    private String password;


    public LoginRequestDTO(String email, String password){
        this.correo = email;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
