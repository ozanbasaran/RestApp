package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Address;
import com.finartz.RestApp.repository.AddressRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Address findById(Long id) {
        return addressRepository.getById(id);
    }

    public Address create(Address address) {
        return addressRepository.save(address);
    }

    public Address update(Address address){
        Address foundAddress = addressRepository.getById(address.getId());
        if(address.getCity()!=null){
            foundAddress.setCity(address.getCity());
        }
        if(address.getCounty()!=null){
            foundAddress.setCounty(address.getCounty());
        }
        if(address.getDistrict() != null) {
            foundAddress.setDistrict(address.getDistrict());
        }
        return addressRepository.save(address);
    }

    public void deleteById(Long id){
        addressRepository.deleteById(id);
    }
}
