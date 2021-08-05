package com.finartz.RestApp.model.converter.dto;

import com.finartz.RestApp.model.converter.GenericConverter;
import com.finartz.RestApp.model.dto.BranchDto;
import com.finartz.RestApp.model.dto.CommentDto;
import com.finartz.RestApp.model.dto.UserDto;
import com.finartz.RestApp.model.entity.BranchEntity;
import com.finartz.RestApp.model.entity.CommentEntity;
import com.finartz.RestApp.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentDtoConverter implements GenericConverter<CommentEntity, CommentDto> {

    private final GenericConverter<UserEntity, UserDto> userDtoConverter;
    private final GenericConverter<BranchEntity, BranchDto> branchDtoConverter;

    @Override
    public CommentDto convert(final CommentEntity commentEntity){
        if(commentEntity == null){
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.setId(commentEntity.getId());
        commentDto.setComment(commentEntity.getComment());
        commentDto.setSpeedPoint(commentEntity.getSpeedPoint());
        commentDto.setTastePoint(commentEntity.getTastePoint());
        commentDto.setUser(convert(commentEntity.getUserEntity()));
        commentDto.setBranch(convert(commentEntity.getBranchEntity()));

        return commentDto;
    }

    private UserDto convert(final UserEntity userEntity){
        return userDtoConverter.convert(userEntity);
    }

    private BranchDto convert(final BranchEntity branchEntity){
        return branchDtoConverter.convert(branchEntity);
    }

}