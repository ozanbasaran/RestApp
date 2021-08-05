package com.finartz.RestApp.service;

import com.finartz.RestApp.model.entity.MealEntity;

import java.util.List;

public interface MealService {

    public List<MealEntity> getMeals();

    public MealEntity getMeal(Long id);

    public MealEntity createMeal(MealEntity mealEntity);

    public MealEntity updateMeal(MealEntity mealEntity);

    public MealEntity deleteMeal(Long id);

}
