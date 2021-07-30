package com.finartz.RestApp.service;

import com.finartz.RestApp.model.CreditCard;
import com.finartz.RestApp.model.CreditCard;
import com.finartz.RestApp.repository.CreditCardRepository;
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
public class CreditCardServiceTest {
    private static final int InitStatus = 124 ;
    private static final int NewStatus= 404;
    @InjectMocks
    private CreditCardService creditCardService;

    @Mock
    private CreditCardRepository creditCardRepository;


    @Test
    public void whenFetchAll_thenReturnAllCreditCard() {
        CreditCard creditCard1 = CreditCard.builder().id(1l).ccv(404).build();
        CreditCard creditCard2 = CreditCard.builder().id(2l).ccv(124).build();
        List<CreditCard> creditCardList = Arrays.asList(creditCard1, creditCard2);

        Mockito.when(creditCardRepository.findAll()).thenReturn(creditCardList);

        List<CreditCard> fetchedList = creditCardService.findAll();

        assertEquals(creditCardList.size(), fetchedList.size());
    }

    @Test
    public void whenFetchById_thenReturnCreditCard() {
        CreditCard creditCard = CreditCard.builder().ccv(404).build();

        Mockito.when(creditCardRepository.getById(1L)).thenReturn(creditCard);

        CreditCard fetchedCreditCard = creditCardService.findById(1L);

        assertEquals(creditCard.getId(), fetchedCreditCard.getId());
    }

    @Test
    public void whenAddCreditCard_thenReturnSavedCreditCard() {
        CreditCard creditCard = CreditCard.builder().ccv(404).build();

        Mockito.doReturn(creditCard).when(creditCardRepository).save(creditCard);

        CreditCard returnedCreditCard = creditCardService.create(creditCard);

        assertEquals(creditCard.getCcv(), returnedCreditCard.getCcv());
    }

    @Test
    public void whenUpdateCreditCard_thenReturnUpdatedCreditCard(){
        CreditCard existCreditCard = CreditCard.builder().id(1L).ccv(InitStatus).build();
        CreditCard newCreditCard = CreditCard.builder().id(1L).ccv(NewStatus).build();
        Mockito.when(creditCardRepository.getById(1L)).thenReturn(existCreditCard);
        Mockito.when(creditCardRepository.save(newCreditCard)).thenReturn(newCreditCard);
        CreditCard updatedCreditCard = creditCardService.update(newCreditCard);
        Assertions.assertEquals(existCreditCard.getCcv(), InitStatus);
        Assertions.assertNotEquals(existCreditCard.getCcv(), NewStatus);
    }

}