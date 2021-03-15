package com.tts.RamazonCommerceSite.repository;

import com.tts.RamazonCommerceSite.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}