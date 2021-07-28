package com.finartz.RestApp.controller;

import com.finartz.RestApp.model.Orders;
import com.finartz.RestApp.service.OrdersService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("orders")
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController (OrdersService ordersService) {
        this.ordersService = ordersService;
    }



    @PostMapping
    public ResponseEntity<Orders> create(@RequestBody Orders orders){
        return new ResponseEntity(ordersService.create(orders), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Orders>> getAll(){
        return new ResponseEntity(ordersService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getById(@PathVariable Long id){
        return new ResponseEntity(ordersService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Orders> update(@RequestBody Orders orders){
        return new ResponseEntity(ordersService.update(orders), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Orders> deleteById(@PathVariable Long id){
        ordersService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
