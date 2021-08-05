package com.finartz.RestApp.model.converter.entity;

import com.finartz.RestApp.model.converter.GenericConverter;
import com.finartz.RestApp.model.dto.BranchDto;
import com.finartz.RestApp.model.dto.UserDto;
import com.finartz.RestApp.model.entity.BranchEntity;
import com.finartz.RestApp.model.entity.CommentEntity;
import com.finartz.RestApp.model.dto.CommentDto;
import com.finartz.RestApp.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentDtoToEntityConverter implements GenericConverter<CommentDto, CommentEntity> {

    private final GenericConverter<UserDto, UserEntity> userEntityConverter;
    private final GenericConverter<BranchDto, BranchEntity> branchEntityConverter;

    @Override
    public CommentEntity convert(final CommentDto comment){
        if(comment == null){
            return null;
        }

        CommentEntity commentEntity = new CommentEntity();

        commentEntity.setId(comment.getId());
        commentEntity.setComment(comment.getComment());
        commentEntity.setSpeedPoint(comment.getSpeedPoint());
        commentEntity.setTastePoint(comment.getTastePoint());
        commentEntity.setUserEntity(convert(comment.getUser()));
        commentEntity.setBranchEntity(convert(comment.getBranch()));

        return commentEntity;
    }

    private UserEntity convert(final UserDto user){
        return userEntityConverter.convert(user);
    }

    private BranchEntity convert(final BranchDto branch){
        return branchEntityConverter.convert(branch);
    }

}