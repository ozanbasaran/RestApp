package com.finartz.RestApp.controller;

import com.finartz.RestApp.model.County;
import com.finartz.RestApp.service.CountyService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("county")
public class CountyController {

    private final CountyService countyService;

    public CountyController (CountyService countyService) {
        this.countyService = countyService;
    }



    @PostMapping
    public ResponseEntity<County> create(@RequestBody County county){
        return new ResponseEntity(countyService.create(county), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<County>> getAll(){
        return new ResponseEntity(countyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<County> getById(@PathVariable Long id){
        return new ResponseEntity(countyService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<County> update(@RequestBody County county){
        return new ResponseEntity(countyService.update(county), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<County> deleteById(@PathVariable Long id){
        countyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
