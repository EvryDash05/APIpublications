package com.project.publications.dto;

import com.project.publications.models.Comment;
import com.project.publications.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDTO implements Serializable {

    private Long publicationId;
    private String tittle;
    private String content;
    /*RELATIONS*/
    private List<CommentDTO> listCommnetsDTOs;
    private UserDTO userDTO;

}
