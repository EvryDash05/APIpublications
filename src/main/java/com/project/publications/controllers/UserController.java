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
        List<UserDTO> userList = userService.getListUsers();
        return userList != null ? ResponseEntity.ok(userList) : ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO){
        User user = userService.createUser(userDTO);
        return user != null ? ResponseEntity.ok("Create user") : ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> userById(@PathVariable Long userId){
        UserDTO userDto = userService.getUserById(userId);
        return userDto != null ? ResponseEntity.ok(userDto) : ResponseEntity.notFound().build();
    }

}
