package com.finartz.RestApp.service;

import com.finartz.RestApp.model.County;

import java.util.List;

public interface CountyService {

    public County create(County county);

    public List<County> findAll();

    public County findById(Long id);

    public County update(County county);

    public County deleteById(Long id);

}