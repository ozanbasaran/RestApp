package com.finartz.RestApp.controller;

import com.finartz.RestApp.model.entity.CreditCardEntity;
import com.finartz.RestApp.service.CreditCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("creditCard")
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("{id}")
    public ResponseEntity<CreditCardEntity> getCreditCard(@PathVariable Long id){
        return new ResponseEntity(creditCardService.getCreditCard(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CreditCardEntity>> getCreditCards(){
        return new ResponseEntity(creditCardService.getCreditCards(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreditCardEntity> createCreditCard(@RequestBody CreditCardEntity creditCardEntity){
        return new ResponseEntity(creditCardService.createCreditCard(creditCardEntity), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CreditCardEntity> updateCreditCard(@RequestBody CreditCardEntity creditCardEntity){
        return new ResponseEntity(creditCardService.updateCreditCard(creditCardEntity), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CreditCardEntity> deleteCreditCard(@PathVariable Long id){
        creditCardService.deleteCreditCard(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}