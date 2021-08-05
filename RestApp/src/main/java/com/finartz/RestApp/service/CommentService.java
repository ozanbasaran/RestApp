package com.finartz.RestApp.service;

import com.finartz.RestApp.model.entity.CommentEntity;

import java.util.List;

public interface CommentService {

    public List<CommentEntity> getComments();

    public CommentEntity getComment(Long id);

    public CommentEntity createComment(CommentEntity commentEntity);

    public CommentEntity updateComment(CommentEntity commentEntity);

    public CommentEntity deleteComment(Long id);
}
