package com.finartz.RestApp.model.converter.entity;

import com.finartz.RestApp.model.converter.GenericConverter;
import com.finartz.RestApp.model.dto.RestaurantDto;
import com.finartz.RestApp.model.dto.UserDto;
import com.finartz.RestApp.model.entity.RestaurantEntity;
import com.finartz.RestApp.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantDtoToEntityConverter implements GenericConverter<RestaurantDto, RestaurantEntity> {

    private final GenericConverter<UserDto, UserEntity> userEntityConverter;
//    private final GenericConverter<BranchDto, BranchEntity> branchEntityConverter;

    @Override
    public RestaurantEntity convert(final RestaurantDto restaurant){
        if(restaurant == null){
            return null;
        }

        RestaurantEntity restaurantEntity = new RestaurantEntity();

        restaurantEntity.setId(restaurant.getId());
        restaurantEntity.setName(restaurant.getName());
        restaurantEntity.setStatus(restaurant.getStatus());
        restaurantEntity.setUserEntity(convert(restaurant.getUser()));

//        List<BranchEntity> branchEntities = new ArrayList<>();
//        restaurant.getBranches().forEach(branch -> {
//            branchEntities.add(convert(branch));
//        });
//        restaurantEntity.setBranchEntities(branchEntities);

        return restaurantEntity;
    }

    private UserEntity convert(final UserDto user){
        return userEntityConverter.convert(user);
    }

//    private BranchEntity convert(final BranchDto branch){
//        return branchEntityConverter.convert(branch);
//    }

}