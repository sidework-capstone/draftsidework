package com.codeup.sidework.daos;

import com.codeup.sidework.models.Business;
import com.codeup.sidework.models.Listing;
import com.codeup.sidework.models.Worker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListingsRepository extends CrudRepository<Listing, Long> {
    List<Listing> findAllByBusiness(Business business);

    @Query(value = "SELECT * FROM listings l WHERE " + "LOWER(l.title) LIKE LOWER(CONCAT('%',:keyword, '%')) OR " + "LOWER(l.description) LIKE LOWER(CONCAT('%',:keyword, '%'))",
            nativeQuery = true)
    List<Listing> search(@Param("keyword") String keyword);
}