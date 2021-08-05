package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Item;

import java.util.List;

public interface ItemService {

    public Item create(Item item);

    public List<Item> findAll();

    public Item findById(Long id);

    public Item update(Item item);

    public Item deleteById(Long id);
}

