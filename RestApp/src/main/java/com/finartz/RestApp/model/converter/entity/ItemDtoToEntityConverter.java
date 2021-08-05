package com.finartz.RestApp.model.converter.entity;

import com.finartz.RestApp.model.converter.GenericConverter;
import com.finartz.RestApp.model.dto.ItemDto;
import com.finartz.RestApp.model.entity.ItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemDtoToEntityConverter implements GenericConverter<ItemDto, ItemEntity> {

//    private final GenericConverter<MealDto, MealEntity> mealEntityConverter;

    @Override
    public ItemEntity convert(final ItemDto item){
        if(item == null){
            return null;
        }

        ItemEntity itemEntity = new ItemEntity();

        itemEntity.setId(item.getId());
        itemEntity.setName(item.getName());
        itemEntity.setUnitType(item.getUnitType());

//        List<MealEntity> mealEntities = new ArrayList<>();
//        item.getMeals().forEach(meal -> {
//            mealEntities.add(convert(meal));
//        });
//        itemEntity.setMealEntities(mealEntities);

        return itemEntity;
    }

//    private MealEntity convert(final MealDto meal){
//        return mealEntityConverter.convert(meal);
//    }

}