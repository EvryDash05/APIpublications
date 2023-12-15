package com.project.publications.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_comments")
@Data
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String commentContent;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime commentDate;

    //Relations
    @ManyToOne
    @JoinColumn(name = "id_publication")
    @JsonBackReference
    private Publication publication;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Comment(){
        this.commentDate = LocalDateTime.now();
    }

    public Comment(String feedbackContent, Publication publication, User user) {
        this.commentContent = feedbackContent;
        this.commentDate = LocalDateTime.now();
        this.publication = publication;
        this.user = user;
    }

}
