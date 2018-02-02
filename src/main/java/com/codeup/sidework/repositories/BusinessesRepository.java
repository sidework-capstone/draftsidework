package com.codeup.sidework.repositories;

import com.codeup.sidework.models.Business;
import org.springframework.data.repository.CrudRepository;

public interface BusinessesRepository extends CrudRepository<Business, Long> {
    Business findByBusinessName(String businessName);
}
