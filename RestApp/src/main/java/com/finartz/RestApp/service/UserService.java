package com.finartz.RestApp.service;

import com.finartz.RestApp.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public UserDetails loadUserByUsername(String email);

    public User create(User user);

    public List<User> findAll();

    public User findById(Long id);

    public User findByEmail(String email);

    public User update(User user);

    public User deleteById(Long id);

}