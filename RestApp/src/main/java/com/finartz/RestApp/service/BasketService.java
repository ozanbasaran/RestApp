package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Basket;
import com.finartz.RestApp.repository.AddressRepository;
import java.util.List;


public interface BasketService {

    public Basket create(Basket basket);

    public List<Basket> findAll();

    public Basket findById(Long id);

    public Basket update(Basket basket);

    public Basket deleteById(Long id);
}