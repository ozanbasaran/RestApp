package com.finartz.RestApp.model.converter.dto;

import com.finartz.RestApp.model.converter.GenericConverter;
import com.finartz.RestApp.model.dto.RestaurantDto;
import com.finartz.RestApp.model.dto.UserDto;
import com.finartz.RestApp.model.entity.RestaurantEntity;
import com.finartz.RestApp.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantDtoConverter implements GenericConverter<RestaurantEntity, RestaurantDto> {

    private final GenericConverter<UserEntity, UserDto> userDtoConverter;
//    private final GenericConverter<BranchEntity, BranchDto> branchDtoConverter;

    @Override
    public RestaurantDto convert(final RestaurantEntity restaurantEntity){
        if(restaurantEntity == null){
            return null;
        }

        RestaurantDto restaurantDto = new RestaurantDto();

        restaurantDto.setId(restaurantEntity.getId());
        restaurantDto.setName(restaurantEntity.getName());
        restaurantDto.setStatus(restaurantEntity.getStatus());
        restaurantDto.setUser(convert(restaurantEntity.getUserEntity()));

//        List<BranchDto> branches = new ArrayList<>();
//        restaurantEntity.getBranchEntities().forEach(branchEntity -> {
//            branches.add(convert(branchEntity));
//        });
//        restaurantDto.setBranches(branches);

        return restaurantDto;
    }

    private UserDto convert(final UserEntity userEntity){
        return userDtoConverter.convert(userEntity);
    }
//    private BranchDto convert(final BranchEntity branchEntity){
//        return branchDtoConverter.convert(branchEntity);
//    }

}