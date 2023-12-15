package com.project.publications.dto;

import com.project.publications.models.Publication;
import com.project.publications.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {


    private String commentContent;
    /*RELATIONS*/
    private Publication publication;
    private User user;

}
