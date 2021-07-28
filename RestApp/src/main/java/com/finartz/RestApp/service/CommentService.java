package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Comment;
import com.finartz.RestApp.repository.CommentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    public Comment findById(Long id) {
        return commentRepository.getById(id);
    }

    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment update(Comment comment){
        Comment update = commentRepository.getById((long) comment.getId());
        if(update != null) {
            commentRepository.save(comment);
            return update;
        }
        return comment;
    }

    public void deleteById(Long id){
        commentRepository.deleteById(id);
    }
}

