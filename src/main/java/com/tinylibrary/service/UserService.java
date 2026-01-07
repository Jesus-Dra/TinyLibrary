package com.tinylibrary.service;


import com.tinylibrary.entity.User;
import com.tinylibrary.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> getOneUser(Integer id){
        Optional<User> oneUser = userRepository.findById(id);

        return oneUser;
    }

    public User createUser(User user){
        User createNewUser = userRepository.save(user);

        return createNewUser;
    }

    public User updateUser(Integer id, User user){
        return userRepository.findById(id).map(existingUser ->{
            existingUser.setAge(user.getAge());
            existingUser.setCorreo(user.getCorreo());
            existingUser.setName(user.getName());
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("el usuario con el id no fue encontrado: "+id));

    }

    public User deleteUser(Integer id){
        Optional<User> userDelete = userRepository.findById(id);

        if(userDelete.isPresent()){

            User existingUser = userDelete.get();
            userRepository.deleteById(existingUser.getId());

            return existingUser;
        }else{
            throw new RuntimeException("El usuario con el id no fue encontrado: "+id);
        }
    }

}
