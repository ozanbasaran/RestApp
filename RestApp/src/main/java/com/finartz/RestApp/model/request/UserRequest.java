package com.finartz.RestApp.model.request;

import com.finartz.RestApp.model.dto.AddressDto;
import com.finartz.RestApp.model.dto.CommentDto;
import com.finartz.RestApp.model.dto.RestaurantDto;
import com.finartz.RestApp.model.enumerated.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserRequest {

    private Long id;

    private String email;

    private String password;

    private String name;

    private List<Role> roles;

    private List<AddressDto> addresses;

    private List<RestaurantDto> restaurants;

    private List<CommentDto> comments;

}
