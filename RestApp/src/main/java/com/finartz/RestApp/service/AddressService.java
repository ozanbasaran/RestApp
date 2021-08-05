package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Address;
import com.finartz.RestApp.repository.AddressRepository;
import java.util.List;


public interface AddressService {

    public Address create(Address address);

    public List<Address> findAll();

    public Address findById(Long id);

    public Address update(Address address);

    public Address deleteById(Long id);
}
