package com.project.publications.controllers;

import com.project.publications.dto.UserDTO;
import com.project.publications.models.User;
import com.project.publications.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/listUsers")
    public ResponseEntity<?> getListUsers(){
        List<User> userList = userService.getListUsers();
        return userList != null ? ResponseEntity.ok(userList) : ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> userById(@PathVariable Long userId){
        User user = userService.getUserById(userId);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

}
