package com.finartz.RestApp.repository;
import com.finartz.RestApp.model.User;
public interface UserRepository extends BaseRepository<User>{
    User findByEmail(String Email);

}
