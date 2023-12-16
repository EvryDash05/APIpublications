package com.project.publications.dto;

import com.project.publications.models.Publication;
import com.project.publications.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO implements Serializable {

    private Long commnetId;
    private String commentContent;
    /*RELATIONS*/
    private PublicationDTO publicationDTO;
    private UserDTO userDTO;

}
