package com.finartz.RestApp.model.dto;

import lombok.Data;

@Data
public class CountyDto {

    private Long id;

    private String name;

    private CityDto city;

}
