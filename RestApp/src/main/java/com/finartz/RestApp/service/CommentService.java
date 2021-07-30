package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Comment;
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
        Comment foundComment = commentRepository.getById(comment.getId());
        if(comment.getBranch()!=null){
            foundComment.setBranch(comment.getBranch());
        }
        if(comment.getComment()!=null){
            foundComment.setComment(comment.getComment());
        }
        if(comment.getUser() != null) {
            foundComment.setUser(comment.getUser());
        }
        return commentRepository.save(comment);
    }

    public void deleteById(Long id){
        commentRepository.deleteById(id);
    }
}

