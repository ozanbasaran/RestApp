package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Restaurant;
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
        Restaurant foundRestaurant = restaurantRepository.getById(restaurant.getId());
        if(restaurant.getBranchList()!=null){
            foundRestaurant.setBranchList(restaurant.getBranchList());
        }
        if(restaurant.getStatus()!=null){
            foundRestaurant.setStatus(restaurant.getStatus());
        }
        if(restaurant.getUser() != null) {
            foundRestaurant.setUser(restaurant.getUser());
        }
        return restaurantRepository.save(restaurant);
    }

    public void deleteById(Long id){
        restaurantRepository.deleteById(id);
    }
}

