package com.finartz.RestApp.model.converter.entity;

import com.finartz.RestApp.model.converter.GenericConverter;
import com.finartz.RestApp.model.dto.BranchDto;
import com.finartz.RestApp.model.dto.UserDto;
import com.finartz.RestApp.model.entity.BranchEntity;
import com.finartz.RestApp.model.entity.CommentEntity;
import com.finartz.RestApp.model.entity.UserEntity;
import com.finartz.RestApp.model.request.CommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentRequestToEntityConverter implements GenericConverter<CommentRequest, CommentEntity> {

    private final GenericConverter<UserDto, UserEntity> userEntityConverter;
    private final GenericConverter<BranchDto, BranchEntity> branchEntityConverter;

    @Override
    public CommentEntity convert(final CommentRequest commentRequest){
        if(commentRequest == null){
            return null;
        }

        CommentEntity commentEntity = new CommentEntity();

        commentEntity.setId(commentRequest.getId());
        commentEntity.setComment(commentRequest.getComment());
        commentEntity.setSpeedPoint(commentRequest.getSpeedPoint());
        commentEntity.setTastePoint(commentRequest.getTastePoint());
        commentEntity.setUserEntity(convert(commentRequest.getUser()));
        commentEntity.setBranchEntity(convert(commentRequest.getBranch()));

        return commentEntity;
    }

    private UserEntity convert(final UserDto user){
        return userEntityConverter.convert(user);
    }

    private BranchEntity convert(final BranchDto branch){
        return branchEntityConverter.convert(branch);
    }

}