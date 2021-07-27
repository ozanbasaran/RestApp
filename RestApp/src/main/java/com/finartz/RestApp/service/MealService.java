package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Meal;
import com.finartz.RestApp.repository.MealRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public List<Meal> findAll(){
        return mealRepository.findAll();
    }

    public Meal findById(Long id) {
        return mealRepository.getById(id);
    }

    public Meal create(Meal meal) {
        return mealRepository.save(meal);
    }

    public Meal update(Meal meal){
        Meal update = mealRepository.getById((long) meal.getId());
        if(update != null) {
            mealRepository.save(meal);
            return update;
        }
        return meal;
    }

    public void deleteById(Long id){
        MealRepository.deleteById(id);
    }
}

