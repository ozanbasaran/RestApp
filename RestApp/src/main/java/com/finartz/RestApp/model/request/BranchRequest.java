package com.finartz.RestApp.model.request;

import com.finartz.RestApp.model.dto.AddressDto;
import com.finartz.RestApp.model.dto.MenuDto;
import com.finartz.RestApp.model.dto.RestaurantDto;
import com.finartz.RestApp.model.enumerated.Status;
import lombok.Data;

@Data
public class BranchRequest {

    private Long id;

    private String name;

    private Status status;

    private RestaurantDto restaurant;

    private MenuDto menu;

    private AddressDto address;

}
