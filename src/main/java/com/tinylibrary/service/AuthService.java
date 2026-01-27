package com.tinylibrary.service;

import com.tinylibrary.config.SecurityConfig;
import com.tinylibrary.dto.LoginRequestDTO;
import com.tinylibrary.dto.LoginResponseDTO;
import com.tinylibrary.entity.User;
import com.tinylibrary.exception.InvalidCredentialsException;
import com.tinylibrary.exception.userNotFound;
import com.tinylibrary.repository.UserRepository;
import com.tinylibrary.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

        public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponseDTO verificationUser(LoginRequestDTO dto){
        User user = userRepository.findByCorreo(dto.getCorreo())
                .orElseThrow(()-> new userNotFound("Usuario no encontrado"));

        if(!passwordEncoder.matches(dto.getPassword(), user.getPassword())){
            throw new InvalidCredentialsException("Credenciales Invalidas");
        }

        String token = jwtService.generateToken(user.getCorreo());

        LoginResponseDTO response = new LoginResponseDTO();

        response.setCorreo(user.getCorreo());
        response.setToken(token);
        response.setMessage("Login exitoso");

        return response;
    }


}
