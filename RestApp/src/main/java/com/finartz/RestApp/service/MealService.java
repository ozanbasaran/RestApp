package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Meal;

import java.util.List;

public interface MealService {

    public Meal create(Meal meal);

    public List<Meal> findAll();

    public Meal findById(Long id);

    public Meal update(Meal meal);

    public Meal deleteById(Long id);

}
