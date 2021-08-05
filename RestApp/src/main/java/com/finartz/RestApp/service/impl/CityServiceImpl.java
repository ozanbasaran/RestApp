package com.finartz.RestApp.service.impl;

import com.finartz.RestApp.model.entity.CityEntity;
import com.finartz.RestApp.repository.CityRepository;
import com.finartz.RestApp.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityEntity> getCities(){
        List<CityEntity> cities = cityRepository.findAll();
        return cities;
    }

    @Override
    public CityEntity getCity(Long id){
        CityEntity cityEntity = cityRepository.getById(id);
        return cityEntity;
    }

    @Override
    public CityEntity createCity(CityEntity cityEntity){
        CityEntity save = cityRepository.save(cityEntity);
        return save;
    }

    @Override
    public CityEntity updateCity(CityEntity cityEntity){
        CityEntity foundCityEntity = cityRepository.getById(cityEntity.getId());

        if(cityEntity.getName() != null)
            foundCityEntity.setName(cityEntity.getName());
        if(cityEntity.getCountyEntities() != null)
            foundCityEntity.setCountyEntities(cityEntity.getCountyEntities());

        return cityRepository.save(foundCityEntity);
    }

    @Override
    public CityEntity deleteCity(Long id){
        CityEntity cityEntity = cityRepository.getById(id);
        if (cityEntity != null) {
            cityRepository.deleteById(id);
            return cityEntity;
        }
        return cityEntity;
    }
}

