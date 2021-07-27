package com.finartz.RestApp.service;

import com.finartz.RestApp.model.User;
import com.finartz.RestApp.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.getById(id);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(User user){
        User update = userRepository.getById((long) user.getId());
        if(update != null) {
            userRepository.save(user);
            return update;
        }
        return user;
    }

    public void deleteById(Long id){
        UserRepository.deleteById(id);
    }
}

