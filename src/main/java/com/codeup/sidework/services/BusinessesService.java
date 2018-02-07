package com.codeup.sidework.services;

import com.codeup.sidework.daos.BusinessesRepository;
import com.codeup.sidework.models.Business;
import org.springframework.stereotype.Service;

@Service
public class BusinessesService {
    private BusinessesRepository businessesRepository;

    public BusinessesService(BusinessesRepository businessesRepository) {
        this.businessesRepository = businessesRepository;
    }

    public Iterable<Business> findAll() {
        return businessesRepository.findAll();
    }
}
