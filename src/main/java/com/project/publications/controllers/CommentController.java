package com.project.publications.controllers;

import com.project.publications.models.Comment;
import com.project.publications.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("(/v1/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/listComments/{publicationId}")
    public ResponseEntity<?> getListCommentByPublication(@PathVariable Long publicationId){
        List<Comment> listComments = commentService.publicationCommentListById(publicationId);
        return listComments != null ? ResponseEntity.ok(listComments) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId){
        commentService.deleteCommentById(commentId);
        return ResponseEntity.ok("Delete comment");
    }


}
