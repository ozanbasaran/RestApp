package com.finartz.RestApp.model.converter.entity;

import com.finartz.RestApp.model.converter.GenericConverter;
import com.finartz.RestApp.model.dto.BranchDto;
import com.finartz.RestApp.model.dto.UserDto;
import com.finartz.RestApp.model.entity.BranchEntity;
import com.finartz.RestApp.model.entity.RestaurantEntity;
import com.finartz.RestApp.model.entity.UserEntity;
import com.finartz.RestApp.model.request.RestaurantRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RestaurantRequestToEntityConverter implements GenericConverter<RestaurantRequest, RestaurantEntity> {

    private final GenericConverter<UserDto, UserEntity> userEntityConverter;
    private final GenericConverter<BranchDto, BranchEntity> branchEntityConverter;

    @Override
    public RestaurantEntity convert(final RestaurantRequest restaurantRequest){
        if(restaurantRequest == null){
            return null;
        }

        RestaurantEntity restaurantEntity = new RestaurantEntity();

        restaurantEntity.setId(restaurantRequest.getId());
        restaurantEntity.setName(restaurantRequest.getName());
        restaurantEntity.setStatus(restaurantRequest.getStatus());
        restaurantEntity.setUserEntity(convert(restaurantRequest.getUser()));

        List<BranchEntity> branchEntities = new ArrayList<>();
        restaurantRequest.getBranches().forEach(branch -> {
            branchEntities.add(convert(branch));
        });
        restaurantEntity.setBranchEntities(branchEntities);

        return restaurantEntity;
    }

    private UserEntity convert(final UserDto user){
        return userEntityConverter.convert(user);
    }

    private BranchEntity convert(final BranchDto branch){
        return branchEntityConverter.convert(branch);
    }

}