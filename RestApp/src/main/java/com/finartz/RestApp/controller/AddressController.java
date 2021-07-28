package com.finartz.RestApp.controller;

import com.finartz.RestApp.model.Address;
import com.finartz.RestApp.service.AddressService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody Address address){
        return new ResponseEntity(addressService.create(address), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAll(){
        return new ResponseEntity(addressService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable Long id){
        return new ResponseEntity(addressService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Address> update(@RequestBody Address address){
        return new ResponseEntity(addressService.update(address), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Address> deleteById(@PathVariable Long id){
        addressService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
