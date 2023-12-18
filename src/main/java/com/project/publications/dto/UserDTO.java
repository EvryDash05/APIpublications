package com.project.publications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private Long userId;
    private String userName;
    private String password;
    private String email;
    private int userAge;

    public UserDTO(String userName, String password, String email, int userAge) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userAge = userAge;
    }

    public UserDTO(Long userId, String userName, int userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
    }

}

