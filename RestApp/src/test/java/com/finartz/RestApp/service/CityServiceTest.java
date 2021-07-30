package com.finartz.RestApp.service;

import com.finartz.RestApp.model.City;
import com.finartz.RestApp.model.City;
import com.finartz.RestApp.repository.CityRepository;
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
public class CityServiceTest {
    private static final String InitStatus = "Adana" ;
    private static final String NewStatus= "Ankara";
    @InjectMocks
    private CityService cityService;

    @Mock
    private CityRepository cityRepository;


    @Test
    public void whenFetchAll_thenReturnAllCity() {
        City branch1 = City.builder().id(1l).name("Adana").build();
        City branch2 = City.builder().id(2l).name("Ankara").build();
        List<City> cityList = Arrays.asList(branch1, branch2);

        Mockito.when(cityRepository.findAll()).thenReturn(cityList);

        List<City> fetchedList = cityService.findAll();

        assertEquals(cityList.size(), fetchedList.size());
    }

    @Test
    public void whenFetchById_thenReturnCity() {
        City city = City.builder().name("Adana").build();

        Mockito.when(cityRepository.getById(1L)).thenReturn(city);

        City fetchedCity = cityService.findById(1L);

        assertEquals(city.getId(), fetchedCity.getId());
    }

    @Test
    public void whenAddCity_thenReturnSavedCity() {
        City city = City.builder().name("Ankara").build();

        Mockito.doReturn(city).when(cityRepository).save(city);

        City returnedCity = cityService.create(city);

        assertEquals(city.getName(), returnedCity.getName());
    }

    @Test
    public void whenUpdateCity_thenReturnUpdatedCity(){
        City existCity = City.builder().id(1L).name(InitStatus).build();
        City newCity = City.builder().id(1L).name(NewStatus).build();
        Mockito.when(cityRepository.getById(1L)).thenReturn(existCity);
        Mockito.when(cityRepository.save(newCity)).thenReturn(newCity);
        City updatedCity = cityService.update(newCity);
        Assertions.assertEquals(existCity.getName(), InitStatus);
        Assertions.assertNotEquals(existCity.getName(), NewStatus);
    }

}