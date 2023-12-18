package com.project.publications.service;


import com.project.publications.dto.UserDTO;
import com.project.publications.dto.mapper.UserMapper;
import com.project.publications.models.User;
import com.project.publications.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import com.project.publications.dto.mapper.UserMapper;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public User createUser(UserDTO userDTO) {
        User user = userMapper.toEntityUser(userDTO);
        return userRepository.save(user);
    }

    public List<UserDTO> getListUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toUsersDto(users);
    }

    public UserDTO getUserById(Long userId) {
        return userMapper.toUserDto(userRepository.findById(userId).orElse(null));
    }

}
