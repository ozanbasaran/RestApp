package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Comment;

import java.util.List;

public interface CommentService {

    public Comment create(Comment comment);

    public List<Comment> findAll();

    public Comment findById(Long id);

    public Comment update(Comment comment);

    public Comment deleteById(Long id);
}

