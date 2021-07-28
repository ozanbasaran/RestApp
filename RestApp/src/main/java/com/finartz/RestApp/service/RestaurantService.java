package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Restaurant;
import com.finartz.RestApp.repository.RestaurantRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> findAll(){
        return restaurantRepository.findAll();
    }

    public Restaurant findById(Long id) {
        return restaurantRepository.getById(id);
    }

    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant update(Restaurant restaurant){
        Restaurant update = restaurantRepository.getById((long) restaurant.getId());
        if(update != null) {
            restaurantRepository.save(restaurant);
            return update;
        }
        return restaurant;
    }

    public void deleteById(Long id){
        restaurantRepository.deleteById(id);
    }
}

