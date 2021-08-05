package com.finartz.RestApp.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CommentServiceTest {
    private static final String InitStatus = "Good!" ;
    private static final String NewStatus= "Bad:(";
    @InjectMocks
    private CommentService commentService;

    @Mock
    private CommentRepository commentRepository;


    @Test
    public void whenFetchAll_thenReturnAllComment() {
        Comment comment1 = Comment.builder().id(1l).comment("It was good").build();
        Comment comment2 = Comment.builder().id(2l).comment("Boo not good !!!").build();
        List<Comment> commentList = Arrays.asList(comment1, comment2);

        Mockito.when(commentRepository.findAll()).thenReturn(commentList);

        List<Comment> fetchedList = commentService.findAll();

        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void whenFetchById_thenReturnComment() {
        Comment comment = Comment.builder().comment("It was good").build();

        Mockito.when(commentRepository.getById(1L)).thenReturn(comment);

        Comment fetchedComment = commentService.findById(1L);

        assertEquals(comment.getId(), fetchedComment.getId());
    }

    @Test
    public void whenAddComment_thenReturnSavedComment() {
        Comment comment = Comment.builder().comment("Good").build();

        Mockito.doReturn(comment).when(commentRepository).save(comment);

        Comment returnedComment = commentService.create(comment);

        assertEquals(comment.getComment(), returnedComment.getComment());
    }

    @Test
    public void whenUpdateComment_thenReturnUpdatedComment(){
        Comment existComment = Comment.builder().id(1L).comment(InitStatus).build();
        Comment newComment = Comment.builder().id(1L).comment(NewStatus).build();
        Mockito.when(commentRepository.getById(1L)).thenReturn(existComment);
        Mockito.when(commentRepository.save(newComment)).thenReturn(newComment);
        Comment updatedComment = commentService.update(newComment);
        Assertions.assertEquals(existComment.getComment(), InitStatus);
        Assertions.assertNotEquals(existComment.getComment(), NewStatus);
    }

}