package com.codeup.sidework.services;

import com.codeup.sidework.daos.BusinessesRepository;
import com.codeup.sidework.models.Business;
import com.codeup.sidework.models.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("businessSvc")
public class BusinessesService {
    private BusinessesRepository businessesRepository;

    @Autowired
    public BusinessesService(BusinessesRepository businessesRepository) {
        this.businessesRepository = businessesRepository;
    }

    public Iterable<Business> findAll() {
        return businessesRepository.findAll();
    }

    public List<Business> searchForBusiness(String keyword) {
        return businessesRepository.search(keyword);
    }
}
