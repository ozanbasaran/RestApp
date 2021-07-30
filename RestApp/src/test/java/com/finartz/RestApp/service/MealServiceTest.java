package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Meal;
import com.finartz.RestApp.model.Meal;
import com.finartz.RestApp.repository.MealRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MealServiceTest {
    private static final String InitStatus = "Pizza" ;
    private static final String NewStatus= "PizzaTost";
    @InjectMocks
    private MealService mealService;

    @Mock
    private MealRepository mealRepository;


    @Test
    public void whenFetchAll_thenReturnAllMeal() {
        Meal county1 = Meal.builder().id(1l).name("Pizza").build();
        Meal county2 = Meal.builder().id(2l).name("PizzaTost").build();
        List<Meal> commentList = Arrays.asList(county1, county2);

        Mockito.when(mealRepository.findAll()).thenReturn(commentList);

        List<Meal> fetchedList = mealService.findAll();

        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void whenFetchById_thenReturnMeal() {
        Meal meal = Meal.builder().name("Pizza").build();

        Mockito.when(mealRepository.getById(1L)).thenReturn(meal);

        Meal fetchedMenu = mealService.findById(1L);

        assertEquals(meal.getId(), fetchedMenu.getId());
    }

    @Test
    public void whenAddMeal_thenReturnSavedMeal() {
        Meal meal = Meal.builder().name("Pizza").build();

        Mockito.doReturn(meal).when(mealRepository).save(meal);

        Meal returnedMeal = mealService.create(meal);

        assertEquals(meal.getName(), returnedMeal.getName());
    }

    @Test
    public void whenUpdateMeal_thenReturnUpdatedMeal(){
        Meal existMeal = Meal.builder().id(1L).name(InitStatus).build();
        Meal newMeal = Meal.builder().id(1L).name(NewStatus).build();
        Mockito.when(mealRepository.getById(1L)).thenReturn(existMeal);
        Mockito.when(mealRepository.save(newMeal)).thenReturn(newMeal);
        Meal updatedMenu = mealService.update(newMeal);
        Assertions.assertEquals(existMeal.getName(), InitStatus);
        Assertions.assertNotEquals(existMeal.getName(), NewStatus);
    }

}