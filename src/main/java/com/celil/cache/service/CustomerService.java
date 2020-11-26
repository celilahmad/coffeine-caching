package com.celil.cache.service;


import com.celil.cache.entity.Customer;
import com.celil.cache.repo.CustomerRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@CacheConfig()
public class CustomerService {

    private final CustomerRepo customerRepo;


    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Cacheable(cacheNames = "cacheManagers")
    public List<Customer> all(){
        log.info("Load all");
        return customerRepo.findAll();
    }
}
