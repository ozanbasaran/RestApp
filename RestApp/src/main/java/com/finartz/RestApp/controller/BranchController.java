package com.finartz.RestApp.controller;

import com.finartz.RestApp.model.Branch;
import com.finartz.RestApp.service.BranchService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("branch")
public class BranchController {

    private final BranchService branchService;
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping
    public ResponseEntity<Branch> create(@RequestBody Branch branch){
        return new ResponseEntity(branchService.create(branch), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Branch>> getAll(){
        return new ResponseEntity(branchService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Branch> getById(@PathVariable Long id){
        return new ResponseEntity(branchService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Branch> update(@RequestBody Branch branch){
        return new ResponseEntity(branchService.update(branch), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Branch> deleteById(@PathVariable Long id){
        branchService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
