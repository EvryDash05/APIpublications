package com.project.publications.service;


import com.project.publications.dto.UserDTO;
import com.project.publications.models.User;
import com.project.publications.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserDTO userDTO) {
        User user = new User(userDTO.getUserName(), userDTO.getPassword(),
                userDTO.getEmail(), userDTO.getUserAge());
        userRepository.save(user);
    }

    public List<User> getListUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

}
