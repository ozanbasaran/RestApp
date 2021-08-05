package com.finartz.RestApp.model.converter.entity;

import com.finartz.RestApp.model.converter.GenericConverter;
import com.finartz.RestApp.model.dto.BranchDto;
import com.finartz.RestApp.model.dto.RestaurantDto;
import com.finartz.RestApp.model.entity.BranchEntity;
import com.finartz.RestApp.model.entity.RestaurantEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BranchDtoToEntityConverter implements GenericConverter<BranchDto, BranchEntity> {

    private final GenericConverter<RestaurantDto, RestaurantEntity> restaurantEntityConverter;
//  private final GenericConverter<MenuDto, MenuEntity> menuEntityConverter;
//  private final GenericConverter<AddressDto, AddressEntity> addressEntityConverter;

    @Override
    public BranchEntity convert(final BranchDto branch){
        if(branch == null){
            return null;
        }

        BranchEntity branchEntity = new BranchEntity();

        branchEntity.setId(branch.getId());
        branchEntity.setName(branch.getName());
        branchEntity.setStatus(branch.getStatus());
        branchEntity.setRestaurantEntity(convert(branch.getRestaurant()));

//      branchEntity.setMenuEntity(convert(branch.getMenu()));
//      branchEntity.setAddressEntity(convert(branch.getAddress()));

        return branchEntity;
    }

    private RestaurantEntity convert(final RestaurantDto restaurant){
        return restaurantEntityConverter.convert(restaurant);
    }

//    private AddressEntity convert(final AddressDto address){
//        return addressEntityConverter.convert(address);
//    }
//
//    private MenuEntity convert(final MenuDto menu){
//        return menuEntityConverter.convert(menu);
//    }

}
