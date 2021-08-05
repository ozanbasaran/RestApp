package com.finartz.RestApp.service;

import com.finartz.RestApp.model.CreditCard;

import java.util.List;

public interface CreditCardService {

    public CreditCard create(CreditCard creditCard);

    public List<CreditCard> findAll();

    public CreditCard findById(Long id);

    public CreditCard update(CreditCard creditCard);

    public CreditCard deleteById(Long id);
}

