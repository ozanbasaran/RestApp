package com.finartz.RestApp.service;

import com.finartz.RestApp.model.enumerated.Status;
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
public class RestaurantServiceTest {
    private static final Status InitStatus = Status.WAITING ;
    private static final Status NewStatus= Status.APPROVED;
    @InjectMocks
    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;


    @Test
    public void whenFetchAll_thenReturnAllRestaurant() {
        Restaurant restaurant1 = Restaurant.builder().id(1l).status(Status.WAITING).build();
        Restaurant restaurant2 = Restaurant.builder().id(2l).status(Status.APPROVED).build();
        List<Restaurant> commentList = Arrays.asList(restaurant1, restaurant2);

        Mockito.when(restaurantRepository.findAll()).thenReturn(commentList);

        List<Restaurant> fetchedList = restaurantService.findAll();

        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void whenFetchById_thenReturnRestaurant() {
        Restaurant restaurant = Restaurant.builder().status(Status.APPROVED).build();

        Mockito.when(restaurantRepository.getById(1L)).thenReturn(restaurant);

        Restaurant fetchedRestaurant = restaurantService.findById(1L);

        assertEquals(restaurant.getId(), fetchedRestaurant.getId());
    }

    @Test
    public void whenAddRestaurant_thenReturnSavedRestaurant() {
        Restaurant restaurant = Restaurant.builder().status(Status.APPROVED).build();

        Mockito.doReturn(restaurant).when(restaurantRepository).save(restaurant);

        Restaurant returnedRestaurant = restaurantService.create(restaurant);

        assertEquals(restaurant.getStatus(), returnedRestaurant.getStatus());
    }

    @Test
    public void whenUpdateRestaurant_thenReturnUpdatedRestaurant(){
        Restaurant existRestaurant = Restaurant.builder().id(1L).status(InitStatus).build();
        Restaurant newRestaurant = Restaurant.builder().id(1L).status(NewStatus).build();
        Mockito.when(restaurantRepository.getById(1L)).thenReturn(existRestaurant);
        Mockito.when(restaurantRepository.save(newRestaurant)).thenReturn(newRestaurant);
        Restaurant updatedRestaurant = restaurantService.update(newRestaurant);
        Assertions.assertEquals(existRestaurant.getStatus(), InitStatus);
        Assertions.assertNotEquals(existRestaurant.getStatus(), NewStatus);
    }

}