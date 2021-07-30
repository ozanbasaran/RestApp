package com.finartz.RestApp.service;

import com.finartz.RestApp.model.User;
import com.finartz.RestApp.model.User;
import com.finartz.RestApp.model.enumerated.Role;
import com.finartz.RestApp.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    private static final Role InitStatus = Role.USER ;
    private static final Role NewStatus= Role.ADMIN;
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;


    @Test
    public void whenFetchAll_thenReturnAllUser() {
        User user1 = User.builder().id(1l).role(Role.USER).build();
        User user2 = User.builder().id(2l).role(Role.ADMIN).build();
        List<User> commentList = Arrays.asList(user1, user2);

        Mockito.when(userRepository.findAll()).thenReturn(commentList);

        List<User> fetchedList = userService.findAll();

        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void whenFetchById_thenReturnUser() {
        User user = User.builder().role(Role.USER).build();

        Mockito.when(userRepository.getById(1L)).thenReturn(user);

        User fetchedUser = userService.findById(1L);

        assertEquals(user.getId(), fetchedUser.getId());
    }

    @Test
    public void whenAddUser_thenReturnSavedUser() {
        User user = User.builder().role(Role.ADMIN).build();

        Mockito.doReturn(user).when(userRepository).save(user);

        User returnedUser = userService.create(user);

        assertEquals(user.getRole(), returnedUser.getRole());
    }

    @Test
    public void whenUpdateUser_thenReturnUpdatedUser(){
        User existUser = User.builder().id(1L).role(InitStatus).build();
        User newUser = User.builder().id(1L).role(NewStatus).build();
        Mockito.when(userRepository.getById(1L)).thenReturn(existUser);
        Mockito.when(userRepository.save(newUser)).thenReturn(newUser);
        User updatedUser = userService.update(newUser);
        Assertions.assertEquals(existUser.getRole(), InitStatus);
        Assertions.assertNotEquals(existUser.getRole(), NewStatus);
    }

}