package com.finartz.RestApp.model.converter.entity;

import com.finartz.RestApp.model.converter.GenericConverter;
import com.finartz.RestApp.model.dto.BranchDto;
import com.finartz.RestApp.model.dto.MealDto;
import com.finartz.RestApp.model.entity.BranchEntity;
import com.finartz.RestApp.model.entity.MealEntity;
import com.finartz.RestApp.model.entity.MenuEntity;
import com.finartz.RestApp.model.request.MenuRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MenuRequestToEntityConverter implements GenericConverter<MenuRequest, MenuEntity> {

    private final GenericConverter<BranchDto, BranchEntity> branchEntityConverter;
    private final GenericConverter<MealDto, MealEntity> mealEntityConverter;

    @Override
    public MenuEntity convert(final MenuRequest menuRequest){
        if(menuRequest == null){
            return null;
        }

        MenuEntity menuEntity = new MenuEntity();

        menuEntity.setId(menuRequest.getId());
        menuEntity.setBranchEntity(convert(menuRequest.getBranch()));

        List<MealEntity> mealEntities = new ArrayList<>();
        menuRequest.getMeals().forEach(meal -> {
            mealEntities.add(convert(meal));
        });
        menuEntity.setMealEntities(mealEntities);

        return menuEntity;
    }

    private BranchEntity convert(BranchDto branch){
        return branchEntityConverter.convert(branch);
    }

    private MealEntity convert(MealDto meal){
        return mealEntityConverter.convert(meal);
    }

}