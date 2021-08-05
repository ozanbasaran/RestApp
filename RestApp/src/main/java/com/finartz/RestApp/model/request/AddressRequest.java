package com.finartz.RestApp.model.request;

import com.finartz.RestApp.model.dto.BranchDto;
import com.finartz.RestApp.model.dto.CityDto;
import com.finartz.RestApp.model.dto.CountyDto;
import com.finartz.RestApp.model.dto.UserDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressRequest {

    private Long id;

    private String name;

    private CityDto city;

    private CountyDto county;

    private String district;

    private String otherContent;

    private Boolean enable;

    private UserDto user;

    private BranchDto branch;

}


