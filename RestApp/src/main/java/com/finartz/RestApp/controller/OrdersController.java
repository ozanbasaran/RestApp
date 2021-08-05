package com.finartz.RestApp.controller;

import com.finartz.RestApp.model.entity.OrdersEntity;
import com.finartz.RestApp.service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("{id}")
    public ResponseEntity<OrdersEntity> getOrders(@PathVariable Long id){
        return new ResponseEntity(ordersService.getOrders(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrdersEntity>> getOrderss(){
        return new ResponseEntity(ordersService.getOrderss(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrdersEntity> createOrders(@RequestBody OrdersEntity ordersEntity){
        return new ResponseEntity(ordersService.createOrders(ordersEntity), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<OrdersEntity> updateOrders(@RequestBody OrdersEntity ordersEntity){
        return new ResponseEntity(ordersService.updateOrders(ordersEntity), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<OrdersEntity> deleteOrders(@PathVariable Long id){
        ordersService.deleteOrders(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}