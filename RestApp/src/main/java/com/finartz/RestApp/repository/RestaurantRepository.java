package com.finartz.RestApp.repository;

import com.finartz.RestApp.model.entity.RestaurantEntity;
import com.finartz.RestApp.model.enumerated.Status;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends BaseRepository<RestaurantEntity> {

    List<RestaurantEntity> findByStatus(Status status);

}
