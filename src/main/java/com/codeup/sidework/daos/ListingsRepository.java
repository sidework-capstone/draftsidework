package com.codeup.sidework.daos;

import com.codeup.sidework.models.Listing;
import org.springframework.data.repository.CrudRepository;

public interface ListingsRepository extends CrudRepository<Listing, Long> {
    Listing findAllById(long id);
}
