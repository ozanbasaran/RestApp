package com.finartz.RestApp.model.converter.dto;

import com.finartz.RestApp.model.converter.GenericConverter;
import com.finartz.RestApp.model.dto.BranchDto;
import com.finartz.RestApp.model.dto.RestaurantDto;
import com.finartz.RestApp.model.entity.BranchEntity;
import com.finartz.RestApp.model.entity.RestaurantEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BranchDtoConverter implements GenericConverter<BranchEntity, BranchDto> {

    private final GenericConverter<RestaurantEntity, RestaurantDto> restaurantDtoConverter;


    @Override
    public BranchDto convert(final BranchEntity branchEntity){
        if(branchEntity == null){
            return null;
        }

        BranchDto branchDto = new BranchDto();

        branchDto.setId(branchEntity.getId());
        branchDto.setName(branchEntity.getName());
        branchDto.setStatus(branchEntity.getStatus());
        branchDto.setRestaurant(convert(branchEntity.getRestaurantEntity()));

        return branchDto;
    }

    private RestaurantDto convert(final RestaurantEntity restaurantEntity){
        return restaurantDtoConverter.convert(restaurantEntity);
    }


}