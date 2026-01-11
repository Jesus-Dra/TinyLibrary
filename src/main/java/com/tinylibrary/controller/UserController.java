package com.tinylibrary.controller;

import com.tinylibrary.dto.UserRequestDTO;
import com.tinylibrary.dto.UserResponseDTO;
import com.tinylibrary.entity.User;
import com.tinylibrary.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tinyLibrary/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDTO> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getOneUser(@PathVariable Integer id){
        UserResponseDTO oneUser = userService.getOneUser(id);

        return ResponseEntity.ok(oneUser);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createNewUser(@Valid @RequestBody UserRequestDTO dto){
        UserResponseDTO createNewUser = userService.createUser(dto);

        return ResponseEntity.ok(createNewUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> UpdateUser(@Valid @PathVariable Integer id, @RequestBody UserRequestDTO dto){
        UserResponseDTO userUpdate = userService.updateUser(id, dto);

        return ResponseEntity.ok(userUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id){
        User userDelete = userService.deleteUser(id);

        return ResponseEntity.ok(userDelete);
    }
}
