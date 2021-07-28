package com.finartz.RestApp.controller;

import com.finartz.RestApp.model.Basket;
import com.finartz.RestApp.service.BasketService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("basket")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping
    public ResponseEntity<Basket> create(@RequestBody Basket basket){
        return new ResponseEntity(basketService.create(basket), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Basket>> getAll(){
        return new ResponseEntity(basketService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Basket> getById(@PathVariable Long id){
        return new ResponseEntity(basketService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Basket> update(@RequestBody Basket basket){
        return new ResponseEntity(basketService.update(basket), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Basket> deleteById(@PathVariable Long id){
        basketService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
