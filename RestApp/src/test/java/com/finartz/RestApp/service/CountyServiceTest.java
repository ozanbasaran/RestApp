package com.finartz.RestApp.service;

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
public class CountyServiceTest {
    private static final String InitStatus = "Çukurova" ;
    private static final String NewStatus= "Seyhan";
    @InjectMocks
    private CountyService countyService;

    @Mock
    private CountyRepository countyRepository;


    @Test
    public void whenFetchAll_thenReturnAllCounty() {
        County county1 = County.builder().id(1l).name("Seyhan").build();
        County county2 = County.builder().id(2l).name("Çukurova").build();
        List<County> commentList = Arrays.asList(county1, county2);

        Mockito.when(countyRepository.findAll()).thenReturn(commentList);

        List<County> fetchedList = countyService.findAll();

        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void whenFetchById_thenReturnCounty() {
        County county = County.builder().name("Çukurova").build();

        Mockito.when(countyRepository.getById(1L)).thenReturn(county);

        County fetchedCounty = countyService.findById(1L);

        assertEquals(county.getId(), fetchedCounty.getId());
    }

    @Test
    public void whenAddCounty_thenReturnSavedCounty() {
        County county = County.builder().name("Çukurova").build();

        Mockito.doReturn(county).when(countyRepository).save(county);

        County returnedCounty = countyService.create(county);

        assertEquals(county.getName(), returnedCounty.getName());
    }

    @Test
    public void whenUpdateCounty_thenReturnUpdatedCounty(){
        County existCounty = County.builder().id(1L).name(InitStatus).build();
        County newCounty = County.builder().id(1L).name(NewStatus).build();
        Mockito.when(countyRepository.getById(1L)).thenReturn(existCounty);
        Mockito.when(countyRepository.save(newCounty)).thenReturn(newCounty);
        County updatedCounty = countyService.update(newCounty);
        Assertions.assertEquals(existCounty.getName(), InitStatus);
        Assertions.assertNotEquals(existCounty.getName(), NewStatus);
    }

}