package com.project.publications.service;

import com.project.publications.dto.PublicationDTO;
import com.project.publications.models.Comment;
import com.project.publications.models.Publication;
import com.project.publications.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    public List<Publication> getListPublications() {
        return publicationRepository.findAll();
    }

    public Publication createPublication(PublicationDTO publicationDTO) {
        Publication publication = new Publication(publicationDTO.getTittle(),
                publicationDTO.getContent(), publicationDTO.getUser());
        return publicationRepository.save(publication);
    }

    public Publication getPublication(Long publicationId) {
        return publicationRepository.findById(publicationId).orElse(null);
    }

    public void addComment(Comment commentDTO, Long publicationId) {

        Comment comment = new Comment(commentDTO.getCommentContent(), commentDTO.getPublication(), commentDTO.getUser());
        Publication publication = getPublication(publicationId);
        publication.addComment(comment);
    }


}
