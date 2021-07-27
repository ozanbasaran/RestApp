package com.finartz.RestApp.service;

import com.finartz.RestApp.model.City;
import com.finartz.RestApp.repository.CityRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAll(){
        return cityRepository.findAll();
    }

    public City findById(Long id) {
        return cityRepository.getById(id);
    }

    public City create(City city) {
        return cityRepository.save(city);
    }

    public City update(City city){
        City update = cityRepository.getById((long) city.getId());
        if(update != null) {
            cityRepository.save(city);
            return update;
        }
        return city;
    }

    public void deleteById(Long id){
        CityRepository.deleteById(id);
    }
}
