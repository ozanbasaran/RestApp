package com.finartz.RestApp.service;

import com.finartz.RestApp.model.entity.RestaurantEntity;
import com.finartz.RestApp.model.enumerated.Status;

import java.util.List;

public interface RestaurantService {

    List<RestaurantEntity> getRestaurants();

    List<RestaurantEntity> getRestaurants(Status status);

    RestaurantEntity getRestaurant(Long id);

    RestaurantEntity createRestaurant(RestaurantEntity restaurantEntity);

    RestaurantEntity updateRestaurant(RestaurantEntity restaurantEntity);

    RestaurantEntity deleteRestaurant(Long id);
}
