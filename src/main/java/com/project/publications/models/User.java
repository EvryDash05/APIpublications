package com.project.publications.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Basic
    private String userName;
    private String password;
    private String email;
    private int userAge;

    /*RELATIONS*/
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Comment> listComments;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Publication> listPublications;

    public User() {
        this.listComments = new ArrayList<>();
        this.listPublications = new ArrayList<>();
    }

    public User(String userName, String password, String email,
                int userAge, List<Comment> listComments, List<Publication> listPublications) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userAge = userAge;
        this.listComments = listComments;
        this.listPublications = listPublications;
    }

    public User(String userName, String password, String email, int userAge) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userAge = userAge;
        this.listComments = new ArrayList<>();
        this.listPublications = new ArrayList<>();
    }

}
