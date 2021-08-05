package com.finartz.RestApp.model.dto;

import lombok.Data;
import java.util.List;

@Data
public class MealDto {

    private Long id;

    private String name;

    private Double price;

    private MenuDto menu;

    private List<ItemDto> items;

}
