package com.finartz.RestApp.model.request;

import com.finartz.RestApp.model.dto.MealDto;
import lombok.Data;

import java.util.List;

@Data
public class ItemRequest {

    private Long id;

    private String name;

    private String unitType;

    private List<MealDto> meals;

}
