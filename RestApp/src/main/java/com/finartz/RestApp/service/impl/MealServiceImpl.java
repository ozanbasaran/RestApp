package com.finartz.RestApp.service.impl;

import com.finartz.RestApp.model.Meal;
import com.finartz.RestApp.repository.MealRepository;
import com.finartz.RestApp.service.MealService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Meal create(Meal meal){
        return mealRepository.save(meal);
    }

    @Override
    public List<Meal> findAll(){
        return mealRepository.findAll();
    }

    @Override
    public Meal findById(Long id){
        return mealRepository.getById(id);
    }

    @Override
    public Meal update(Meal meal){
        Meal foundMeal = mealRepository.getById(meal.getId());

        if(meal.getName() != null)
            foundMeal.setName(meal.getName());
        if(meal.getPrice() != null)
            foundMeal.setPrice(meal.getPrice());
        if(meal.getMenu() != null)
            foundMeal.setMenu(meal.getMenu());
        if(meal.getItemList() != null)
            foundMeal.setItemList(meal.getItemList());
        if(meal.getBasketMealList() != null)
            foundMeal.setBasketMealList(meal.getBasketMealList());

        return mealRepository.save(foundMeal);
    }

    @Override
    public Meal deleteById(Long id){
        Meal meal = mealRepository.getById(id);
        if (meal != null) {
            mealRepository.deleteById(id);
            return meal;
        }
        return meal;
    }

}