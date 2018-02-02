package com.codeup.sidework.repositories;

import com.codeup.sidework.models.Business;
import org.springframework.data.repository.CrudRepository;

public interface Businesses extends CrudRepository<Business, Long> {
    Business findByBusinessName(String businessName);
}
