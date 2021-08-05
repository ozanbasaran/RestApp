package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Restaurant;
import com.finartz.RestApp.model.enumerated.Status;

import java.util.List;

public interface RestaurantService {

    public Restaurant create(Restaurant restaurant);

    public List<Restaurant> findAll();

    public Restaurant findById(Long id);

    public List<Restaurant> findByStatus(Status status);

    public Restaurant update(Restaurant restaurant);

    public Restaurant deleteById(Long id);
}

