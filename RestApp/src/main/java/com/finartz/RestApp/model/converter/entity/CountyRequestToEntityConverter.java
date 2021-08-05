package com.finartz.RestApp.model.converter.entity;

import com.finartz.RestApp.model.converter.GenericConverter;
import com.finartz.RestApp.model.dto.CityDto;
import com.finartz.RestApp.model.entity.CityEntity;
import com.finartz.RestApp.model.entity.CountyEntity;
import com.finartz.RestApp.model.request.CountyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountyRequestToEntityConverter implements GenericConverter<CountyRequest, CountyEntity> {

    private final GenericConverter<CityDto, CityEntity> cityEntityConverter;

    @Override
    public CountyEntity convert(final CountyRequest countyRequest){
        if(countyRequest == null){
            return null;
        }

        CountyEntity countyEntity = new CountyEntity();

        countyEntity.setId(countyRequest.getId());
        countyEntity.setName(countyRequest.getName());
        countyEntity.setCityEntity(convert(countyRequest.getCity()));

        return countyEntity;
    }

    private CityEntity convert(final CityDto city){
        return cityEntityConverter.convert(city);
    }

}