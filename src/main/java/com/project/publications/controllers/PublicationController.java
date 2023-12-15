package com.project.publications.controllers;

import com.project.publications.dto.PublicationDTO;
import com.project.publications.models.Publication;
import com.project.publications.models.User;
import com.project.publications.service.PublicationService;
import com.project.publications.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/publications")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;
    @Autowired
    private UserService userService;


    @GetMapping("/listPublications")
    public ResponseEntity<?> getListPublications() {
        List<Publication> publicationsList = publicationService.getListPublications();
        return publicationsList != null ? ResponseEntity.ok(publicationsList) : ResponseEntity.notFound().build();
    }

    @PostMapping("/createPublication/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void getPublicationsList(@RequestBody PublicationDTO publicationDTO, @PathVariable Long userId) {
        User findUser = userService.getUserById(userId);
        publicationDTO.setUser(findUser);
        if (findUser != null) {
            publicationService.createPublication(publicationDTO);
        }
    }

}