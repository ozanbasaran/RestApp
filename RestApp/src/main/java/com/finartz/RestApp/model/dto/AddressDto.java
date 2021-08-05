package com.finartz.RestApp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

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
