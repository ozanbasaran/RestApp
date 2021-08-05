package com.finartz.RestApp.model.request;

import com.finartz.RestApp.model.dto.BranchDto;
import com.finartz.RestApp.model.dto.UserDto;
import lombok.Data;

@Data
public class CommentRequest {

    private Long id;

    private String comment;

    private Integer tastePoint;

    private Integer speedPoint;

    private UserDto user;

    private BranchDto branch;

}
