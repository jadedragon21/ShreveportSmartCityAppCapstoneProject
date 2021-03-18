package com.tts.capstone.SmartShreveCity.repository;

import com.tts.capstone.SmartShreveCity.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}