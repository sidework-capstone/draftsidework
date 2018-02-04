package com.codeup.sidework.daos;

import com.codeup.sidework.models.Division;
import com.codeup.sidework.models.Listings;
import org.springframework.data.repository.CrudRepository;

public interface ListingsRepository extends CrudRepository<Listings, Long> {
    Listings findAllById(long id);

}
