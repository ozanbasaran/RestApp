package com.finartz.RestApp.model.dto;

import com.finartz.RestApp.model.enumerated.Status;
import lombok.Data;

@Data
public class RestaurantDto {

    private Long id;

    private String name;

    private Status status;

    private UserDto user;

}
