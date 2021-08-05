package com.finartz.RestApp.model.request;

import com.finartz.RestApp.model.dto.BranchDto;
import com.finartz.RestApp.model.dto.UserDto;
import com.finartz.RestApp.model.enumerated.Status;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantRequest {

    private Long id;

    private String name;

    private Status status;

    private UserDto user;

    private List<BranchDto> branches;

}
