package com.finartz.RestApp.service;

import com.finartz.RestApp.model.County;
import com.finartz.RestApp.model.County;
import com.finartz.RestApp.repository.CountyRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CountyService {

    private final CountyRepository countyRepository;

    public CountyService(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    public List<County> findAll(){
        return countyRepository.findAll();
    }

    public County findById(Long id) {
        return countyRepository.getById(id);
    }

    public County create(County county) {
        return countyRepository.save(county);
    }

    public County update(County county){
        County foundCounty = countyRepository.getById(county.getId());
        if(county.getName()!=null){
            foundCounty.setName(county.getName());
        }
        return countyRepository.save(county);
    }

    public void deleteById(Long id){
        countyRepository.deleteById(id);
    }
}

