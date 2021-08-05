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
public class AddressServiceTest {
private static String  DISTRICT_MODA = "Moda";
private static String  DISTRICT_CAFERAGA = "Caferağa";


    @InjectMocks
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;


    @Test
    public void whenFetchAll_thenReturnAllAddress() {
        Address address1 = Address.builder().id(1l).name("Kampüs").build();
        Address address2 = Address.builder().id(2l).name("Ev").build();
        Address address3 = Address.builder().id(3l).name("İş").build();
        List<Address> addressList = Arrays.asList(address1, address2,address3);

        Mockito.when(addressRepository.findAll()).thenReturn(addressList);

        List<Address> fetchedList = addressService.findAll();

        assertEquals(addressList.size(), fetchedList.size());
    }

    @Test
    public void whenFetchById_thenReturnAddress() {
        Address address = Address.builder().name("Ev").district("Yenişehir Mahallesi").build();

        Mockito.when(addressRepository.getById(1L)).thenReturn(address);

        Address fetchedAddress = addressService.findById(1L);

        assertEquals(address.getId(), fetchedAddress.getId());
    }

    @Test
    public void whenAddAddress_thenReturnSavedAddress() {
        Address address = Address.builder().name("Ev").build();

        Mockito.doReturn(address).when(addressRepository).save(address);

        Address returnedAddress = addressService.create(address);

        assertEquals(address.getName(), returnedAddress.getName());
    }

    @Test
    public void whenUpdateAddress_thenReturnUpdatedAddress(){
        Address existAddress = Address.builder().id(1L).district(DISTRICT_MODA).build();
        Address newAddress = Address.builder().id(1L).district(DISTRICT_CAFERAGA).build();
        Mockito.when(addressRepository.getById(1L)).thenReturn(existAddress);
        Mockito.when(addressRepository.save(newAddress)).thenReturn(newAddress);
        Address updatedAddress = addressService.update(newAddress);
        Assertions.assertNotEquals(existAddress.getDistrict(), DISTRICT_MODA);
        Assertions.assertEquals(existAddress.getDistrict(), DISTRICT_CAFERAGA);

    }

}