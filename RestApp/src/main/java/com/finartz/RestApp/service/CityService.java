package com.finartz.RestApp.service;
import com.finartz.RestApp.model.City;

import java.util.List;

public interface CityService {

    public City create(City city);

    public List<City> findAll();

    public City findById(Long id);

    public City update(City city);

    public City deleteById(Long id);
}