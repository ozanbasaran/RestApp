package com.finartz.RestApp.controller;

import com.finartz.RestApp.model.Comment;
import com.finartz.RestApp.service.CommentService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController (CommentService commentService) {
        this.commentService = commentService;
    }



    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody Comment comment){
        return new ResponseEntity(commentService.create(comment), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAll(){
        return new ResponseEntity(commentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getById(@PathVariable Long id){
        return new ResponseEntity(commentService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Comment> update(@RequestBody Comment comment){
        return new ResponseEntity(commentService.update(comment), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Comment> deleteById(@PathVariable Long id){
        commentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
