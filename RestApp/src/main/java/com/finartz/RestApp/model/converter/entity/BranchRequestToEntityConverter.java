package com.finartz.RestApp.model.converter.entity;

import com.finartz.RestApp.model.converter.GenericConverter;
import com.finartz.RestApp.model.dto.AddressDto;
import com.finartz.RestApp.model.dto.MenuDto;
import com.finartz.RestApp.model.dto.RestaurantDto;
import com.finartz.RestApp.model.entity.AddressEntity;
import com.finartz.RestApp.model.entity.BranchEntity;
import com.finartz.RestApp.model.entity.MenuEntity;
import com.finartz.RestApp.model.entity.RestaurantEntity;
import com.finartz.RestApp.model.request.BranchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BranchRequestToEntityConverter implements GenericConverter<BranchRequest, BranchEntity> {

    private final GenericConverter<MenuDto, MenuEntity> menuEntityConverter;
    private final GenericConverter<RestaurantDto, RestaurantEntity> restaurantEntityConverter;
    private final GenericConverter<AddressDto, AddressEntity> addressEntityConverter;

    @Override
    public BranchEntity convert(final BranchRequest branchRequest){
        if(branchRequest == null){
            return null;
        }

        BranchEntity branchEntity = new BranchEntity();

        branchEntity.setId(branchRequest.getId());
        branchEntity.setName(branchRequest.getName());
        branchEntity.setStatus(branchRequest.getStatus());
        branchEntity.setMenuEntity(convert(branchRequest.getMenu()));
        branchEntity.setRestaurantEntity(convert(branchRequest.getRestaurant()));
        branchEntity.setAddressEntity(convert(branchRequest.getAddress()));



        return branchEntity;
    }

    private AddressEntity convert(final AddressDto address){
        return addressEntityConverter.convert(address);
    }

    private RestaurantEntity convert(final RestaurantDto restaurant){
        return restaurantEntityConverter.convert(restaurant);
    }

    private MenuEntity convert(final MenuDto menu){
        return menuEntityConverter.convert(menu);
    }

}
