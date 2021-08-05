package com.finartz.RestApp.model.request;

import com.finartz.RestApp.model.dto.ItemDto;
import com.finartz.RestApp.model.dto.MenuDto;
import lombok.Data;

import java.util.List;

@Data
public class MealRequest {

    private Long id;

    private String name;

    private Double price;

    private MenuDto menu;

    private List<ItemDto> items;

}
