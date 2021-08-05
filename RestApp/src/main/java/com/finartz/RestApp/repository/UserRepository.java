package com.finartz.RestApp.repository;

import com.finartz.RestApp.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity> {

    UserEntity findByEmail(String Email);

}
