package com.finartz.RestApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class BasketMealKey extends BaseDTO{

    @Column(name = "basket_id")
    private Long basketId;

    @Column(name= "meal_id")
    private Long mealId;

}
