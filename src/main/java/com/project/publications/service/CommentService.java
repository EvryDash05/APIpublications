package com.project.publications.service;

import com.project.publications.dto.CommentDTO;
import com.project.publications.models.Comment;
import com.project.publications.models.Publication;
import com.project.publications.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PublicationService publicationService;

    /*public List<Comment> publicationCommentListById(Long publicationId){
        Publication publication = publicationService.getPublicationById(publicationId);
        return publication.getListComments();
    }

    public void createComment(Long publicationId, CommentDTO commentDTO){

        Publication publication = publicationService.getPublicationById(publicationId);

        if(publication != null){
            Comment comment = new Comment(commentDTO.getCommentContent(), publication, publication.getUser());
            publication.addComment(comment);
            //publicationService.createPublication();
        }

    }

    public boolean deleteCommentById(Long publicationId){
        commentRepository.deleteById(publicationId);
        return true;
    }*/

}
