package com.project.publications.dto;

import com.project.publications.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDTO {

    private String tittle;
    private String content;
    /*RELATIONS*/
    private User user;

}
