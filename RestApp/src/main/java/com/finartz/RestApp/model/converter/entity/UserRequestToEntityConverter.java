package com.finartz.RestApp.model.converter.entity;

import com.finartz.RestApp.model.converter.GenericConverter;
import com.finartz.RestApp.model.dto.AddressDto;
import com.finartz.RestApp.model.dto.CommentDto;
import com.finartz.RestApp.model.dto.RestaurantDto;
import com.finartz.RestApp.model.entity.AddressEntity;
import com.finartz.RestApp.model.entity.CommentEntity;
import com.finartz.RestApp.model.entity.RestaurantEntity;
import com.finartz.RestApp.model.entity.UserEntity;
import com.finartz.RestApp.model.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserRequestToEntityConverter implements GenericConverter<UserRequest, UserEntity> {

    private final GenericConverter<AddressDto, AddressEntity> addressEntityConverter;
    private final GenericConverter<RestaurantDto, RestaurantEntity> restaurantEntityConverter;
    private final GenericConverter<CommentDto, CommentEntity> commentEntityConverter;

    @Override
    public UserEntity convert(final UserRequest userRequest){
        if(userRequest == null){
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId(userRequest.getId());
        userEntity.setName(userRequest.getName());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setRoles(userRequest.getRoles());

        List<AddressEntity> addressEntities = new ArrayList<>();
        userRequest.getAddresses().forEach(address -> {
            addressEntities.add(convert(address));
        });
        userEntity.setAddressEntities(addressEntities);

        List<RestaurantEntity> restaurantEntities = new ArrayList<>();
        userRequest.getRestaurants().forEach(restaurant -> {
            restaurantEntities.add(convert(restaurant));
        });
        userEntity.setRestaurantEntities(restaurantEntities);

        List<CommentEntity> commentEntities = new ArrayList<>();
        userRequest.getComments().forEach(comment -> {
            commentEntities.add(convert(comment));
        });
        userEntity.setCommentEntities(commentEntities);

        return userEntity;
    }

    private AddressEntity convert(final AddressDto address){
        return addressEntityConverter.convert(address);
    }

    private RestaurantEntity convert(final RestaurantDto restaurant){
        return restaurantEntityConverter.convert(restaurant);
    }

    private CommentEntity convert(final CommentDto comment){
        return commentEntityConverter.convert(comment);
    }

}