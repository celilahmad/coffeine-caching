package com.celil.cache.service;


import com.celil.cache.entity.User;
import com.celil.cache.repo.UserRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@CacheConfig
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers(){
        log.info("Get All");
        return userRepo.findAll();
    }

    @Cacheable(cacheNames = "cacheManagers")
    public Optional<User> getUserById(int userId) {
        log.info("Fetching customer by id: {}", userId);
        return userRepo.findById(userId);
    }
}
