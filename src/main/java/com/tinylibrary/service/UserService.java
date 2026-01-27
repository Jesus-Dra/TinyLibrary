package com.tinylibrary.service;


import com.tinylibrary.config.SecurityConfig;
import com.tinylibrary.dto.UserRequestDTO;
import com.tinylibrary.dto.UserResponseDTO;
import com.tinylibrary.entity.User;
import com.tinylibrary.exception.CorreoAlreadyExistException;
import com.tinylibrary.exception.userNotFound;
import com.tinylibrary.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    //Entity -> DTO & DTO -> Entity

    private User dtoToEntity(UserRequestDTO dto){
        User convert = new User();
        convert.setName(dto.getName());
        convert.setAge(dto.getAge());
        convert.setCorreo(dto.getCorreo());
        convert.setPassword(passwordEncoder.encode(dto.getPassword()));
        return convert;
    }

    private UserResponseDTO entityToDto(User convert){
        UserResponseDTO convertToDto = new UserResponseDTO();
        convertToDto.setName(convert.getName());
        convertToDto.setAge(convert.getAge());
        convertToDto.setCorreo(convert.getCorreo());
        return convertToDto;
    }


    public List<UserResponseDTO> getAllUser(){
        
        List<User> allUser = userRepository.findAll();
        List<UserResponseDTO> convertList = new ArrayList<>();

        for(User users : allUser){
            convertList.add(entityToDto(users));
        }

        return convertList;
    }

    public UserResponseDTO getOneUser(Integer id){

        return userRepository.findById(id).map(this::entityToDto)
                .orElseThrow(() -> new userNotFound("El usuario no fue encontrado"));

    }

    public UserResponseDTO createUser(UserRequestDTO dto){

        userRepository.findByCorreo(dto.getCorreo()).ifPresent(userExisting ->{
            throw new CorreoAlreadyExistException("El correo ya esta vinculado con otro usuario: "+dto.getCorreo());
        });

        User userEntity = dtoToEntity(dto);

        userRepository.save(userEntity);

        return entityToDto(userEntity);

    }

    public UserResponseDTO updateUser(Integer id, UserRequestDTO dto){
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new userNotFound("El usuario no fue encontrado"));

        User saveUser = dtoToEntity(dto);

        existing.setName(saveUser.getName());
        existing.setCorreo(saveUser.getCorreo());
        existing.setAge(saveUser.getAge());

        User update = userRepository.save(existing);
        return entityToDto(update);

    }

    public User deleteUser(Integer id){
        Optional<User> userDelete = userRepository.findById(id);

        if(userDelete.isPresent()){

            User existingUser = userDelete.get();
            userRepository.deleteById(existingUser.getId());

            return existingUser;
        }else{
            throw new userNotFound("El usuario con el id no fue encontrado: "+id);
        }
    }

}
