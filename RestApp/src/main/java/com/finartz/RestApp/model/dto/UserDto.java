package com.finartz.RestApp.model.dto;

import com.finartz.RestApp.model.enumerated.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Long id;

    private String email;

    private String password;

    private String name;

    private List<Role> roles;

}
