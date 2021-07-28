package com.finartz.RestApp.controller;

import com.finartz.RestApp.model.Restaurant;
import com.finartz.RestApp.service.RestaurantService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController (RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }



    @PostMapping
    public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurant){
        return new ResponseEntity(restaurantService.create(restaurant), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAll(){
        return new ResponseEntity(restaurantService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getById(@PathVariable Long id){
        return new ResponseEntity(restaurantService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Restaurant> update(@RequestBody Restaurant restaurant){
        return new ResponseEntity(restaurantService.update(restaurant), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Restaurant> deleteById(@PathVariable Long id){
        restaurantService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
