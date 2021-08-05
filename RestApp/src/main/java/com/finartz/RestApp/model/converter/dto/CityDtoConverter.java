package com.finartz.RestApp.model.converter.dto;

import com.finartz.RestApp.model.converter.GenericConverter;
import com.finartz.RestApp.model.dto.CityDto;
import com.finartz.RestApp.model.entity.CityEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CityDtoConverter implements GenericConverter<CityEntity, CityDto> {

    @Override
    public CityDto convert(final CityEntity cityEntity){
        if(cityEntity == null){
            return null;
        }

        CityDto cityDto = new CityDto();

        cityDto.setId(cityEntity.getId());
        cityDto.setName(cityEntity.getName());


        return cityDto;
    }


}