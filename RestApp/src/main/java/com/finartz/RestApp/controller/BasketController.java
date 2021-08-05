package com.finartz.RestApp.controller;

import com.finartz.RestApp.model.dto.BasketDto;
import com.finartz.RestApp.model.entity.BasketEntity;
import com.finartz.RestApp.model.request.BasketRequest;
import com.finartz.RestApp.service.BasketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("basket")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("{id}")
    public ResponseEntity<BasketDto> getBasket(@PathVariable Long id){
        return new ResponseEntity(basketService.getBasket(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BasketDto>> getBasketes(){
        return new ResponseEntity(basketService.getBasketes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BasketDto> createBasket(@RequestBody BasketRequest basketRequest){
        return new ResponseEntity(basketService.createBasket(basketRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BasketEntity> updateBasket(@RequestBody BasketRequest basketRequest){
        return new ResponseEntity(basketService.updateBasket(basketRequest), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteBasket(@PathVariable Long id){
        basketService.deleteBasket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}