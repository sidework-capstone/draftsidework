package com.codeup.sidework.daos;

import com.codeup.sidework.models.Business;
import com.codeup.sidework.models.Listing;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ListingsRepository extends CrudRepository<Listing, Long> {
    List<Listing> findAllByBusiness(Business business);
}
