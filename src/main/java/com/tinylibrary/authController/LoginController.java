package com.tinylibrary.authController;

import com.tinylibrary.dto.LoginRequestDTO;
import com.tinylibrary.dto.LoginResponseDTO;
import com.tinylibrary.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/tinyLibrary/login")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<LoginResponseDTO> loginInitial(@Valid @RequestBody LoginRequestDTO dto){
        return ResponseEntity.ok(authService.verificationUser(dto));
    }


}
