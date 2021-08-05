package com.finartz.RestApp.service;

import com.finartz.RestApp.model.dto.AddressDto;
import com.finartz.RestApp.model.request.AddressRequest;

import java.util.List;

public interface AddressService {

    List<AddressDto> getAddresses();

    AddressDto getAddress(Long id);

    AddressDto createAddress(AddressRequest addressRequest);

    AddressDto updateAddress(AddressRequest addressRequest);

    AddressDto deleteAddress(Long id);

}
