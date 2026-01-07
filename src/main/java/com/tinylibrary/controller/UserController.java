package com.tinylibrary.controller;

import com.tinylibrary.entity.User;
import com.tinylibrary.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tinyLibrary/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUser(){
        List<User> allUser = userService.getAllUser();

        return allUser;
    }

    @GetMapping("/{id}")
    public Optional<User> getOneUser(@PathVariable Integer id){
        Optional<User> oneUser = userService.getOneUser(id);

        return oneUser;
    }

    @PostMapping
    public User createNewuser(@RequestBody User user){
        User createNewUser = userService.createUser(user);

        return createNewUser;
    }

    @PutMapping("/{id}")
    public User UpdateUser(@PathVariable Integer id, @RequestBody User user){
        User userUpdate = userService.updateUser(id, user);

        return userUpdate;
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable Integer id){
        User userDelete = userService.deleteUser(id);

        return userDelete;
    }
}
