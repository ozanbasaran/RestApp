package com.finartz.RestApp.model.request;

import com.finartz.RestApp.model.dto.BranchDto;
import com.finartz.RestApp.model.dto.MealDto;
import lombok.Data;

import java.util.List;

@Data
public class MenuRequest {

    private Long id;

    private BranchDto branch;

    private List<MealDto> meals;

}
