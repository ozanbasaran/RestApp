package com.finartz.RestApp.model.request;

import com.finartz.RestApp.model.dto.CityDto;
import lombok.Data;

@Data
public class CountyRequest {

    private Long id;

    private String name;

    private CityDto city;


}
