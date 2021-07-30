package com.finartz.RestApp.service;

import com.finartz.RestApp.model.User;
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
        User foundUser = userRepository.getById(user.getId());
        if(user.getAddressList()!=null){
            foundUser.setAddressList(user.getAddressList());
        }
        if(user.getCommentList()!=null){
            foundUser.setCommentList(user.getCommentList());
        }
        if(user.getPassword() != null) {
            foundUser.setPassword(user.getPassword());
        }
        if(user.getCreditCardList()!=null){
            foundUser.setCreditCardList(user.getCreditCardList());
        }
        if(user.getRestaurantList()!=null){
            foundUser.setRestaurantList(user.getRestaurantList());
        }
        if(user.getRole()!=null){
            foundUser.setRole(user.getRole());
        }
        return userRepository.save(user);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}

