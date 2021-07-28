package com.finartz.RestApp.controller;

import com.finartz.RestApp.model.CreditCard;
import com.finartz.RestApp.service.CreditCardService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("creditCard")
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController (CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }



    @PostMapping
    public ResponseEntity<CreditCard> create(@RequestBody CreditCard creditCard){
        return new ResponseEntity(creditCardService.create(creditCard), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CreditCard>> getAll(){
        return new ResponseEntity(creditCardService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCard> getById(@PathVariable Long id){
        return new ResponseEntity(creditCardService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CreditCard> update(@RequestBody CreditCard creditCard){
        return new ResponseEntity(creditCardService.update(creditCard), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<CreditCard> deleteById(@PathVariable Long id){
        creditCardService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
