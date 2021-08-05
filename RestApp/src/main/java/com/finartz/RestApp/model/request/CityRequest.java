package com.finartz.RestApp.model.request;

import com.finartz.RestApp.model.dto.CountyDto;
import lombok.Data;

import java.util.List;

@Data
public class CityRequest {

    private Long id;

    private String name;

    private List<CountyDto> counties;

}
