package com.finartz.RestApp.controller;

import com.finartz.RestApp.model.Item;
import com.finartz.RestApp.service.ItemService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("item")
public class ItemController {

    private final ItemService itemService;

    public ItemController (ItemService itemService) {
        this.itemService = itemService;
    }



    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item item){
        return new ResponseEntity(itemService.create(item), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAll(){
        return new ResponseEntity(itemService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable Long id){
        return new ResponseEntity(itemService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Item> update(@RequestBody Item item){
        return new ResponseEntity(itemService.update(item), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Item> deleteById(@PathVariable Long id){
        itemService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
