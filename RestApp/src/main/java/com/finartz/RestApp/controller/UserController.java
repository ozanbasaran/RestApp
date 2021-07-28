package com.finartz.RestApp.controller;

import com.finartz.RestApp.model.User;
import com.finartz.RestApp.service.UserService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }



    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        return new ResponseEntity(userService.create(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        return new ResponseEntity(userService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user){
        return new ResponseEntity(userService.update(user), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
