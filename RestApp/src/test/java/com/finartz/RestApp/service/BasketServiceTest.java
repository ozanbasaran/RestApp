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
public class BasketServiceTest {
private static final Double InitPrice = 100.0 ;
private static final Double NewPrice= 199.0;
    @InjectMocks
    private BasketService basketService;

    @Mock
    private BasketRepository basketRepository;


    @Test
    public void whenFetchAll_thenReturnAllBasket() {
        Basket basket1 = Basket.builder().id(1l).totalPrice(123456.789).build();
        Basket basket2 = Basket.builder().id(2l).totalPrice(987654.321).build();
        List<Basket> basketList = Arrays.asList(basket1, basket2);

        Mockito.when(basketRepository.findAll()).thenReturn(basketList);

        List<Basket> fetchedList = basketService.findAll();

        assertEquals(basketList.size(), fetchedList.size());
    }

    @Test
    public void whenFetchById_thenReturnBasket() {
        Basket basket = Basket.builder().totalPrice(123456.789).build();

        Mockito.when(basketRepository.getById(1L)).thenReturn(basket);

        Basket fetchedBasket = basketService.findById(1L);

        assertEquals(basket.getId(), fetchedBasket.getId());
    }

    @Test
    public void whenAddBasket_thenReturnSavedBasket() {
        Basket basket = Basket.builder().totalPrice(123456.789).build();

        Mockito.doReturn(basket).when(basketRepository).save(basket);

        Basket returnedBasket = basketService.create(basket);

        assertEquals(basket.getTotalPrice(), returnedBasket.getTotalPrice());
    }

    @Test
    public void whenUpdateBasket_thenReturnUpdatedBasket(){
        Basket existBasket = Basket.builder().id(1L).totalPrice(InitPrice).build();
        Basket newBasket = Basket.builder().id(1L).totalPrice(NewPrice).build();
        Mockito.when(basketRepository.getById(1L)).thenReturn(existBasket);
        Mockito.when(basketRepository.save(newBasket)).thenReturn(newBasket);
        Basket updatedBasket = basketService.update(newBasket);
        Assertions.assertEquals(existBasket.getTotalPrice(), InitPrice);
        Assertions.assertNotEquals(existBasket.getTotalPrice(), NewPrice);
    }

}