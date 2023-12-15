package com.project.publications.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_publications")
@Data
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String tittle;
    private String content;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime publishedDate;

    //Relations
    @OneToMany(mappedBy = "publication")
    @JsonManagedReference
    private List<Comment> listComments;

    @ManyToOne()
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private User user;

    public Publication() {
        this.publishedDate = LocalDateTime.now();
        this.listComments = new ArrayList<>();
    }

    public Publication(String tittle, String content, User user) {
        this.tittle = tittle;
        this.content = content;
        this.publishedDate = LocalDateTime.now();
        this.listComments = new ArrayList<>();
        this.user = user;
    }
    
    public void addComment(Comment comment) {
        this.listComments.add(comment);
    }

}
