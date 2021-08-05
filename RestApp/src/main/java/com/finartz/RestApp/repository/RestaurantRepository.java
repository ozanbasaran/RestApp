package com.finartz.RestApp.repository;
import com.finartz.RestApp.model.Restaurant;
import com.finartz.RestApp.model.enumerated.Status;

import java.util.List;

public interface RestaurantRepository extends BaseRepository<Restaurant>{
    List<Restaurant> findByStatus(Status status);
}
