package com.codeup.sidework.daos;

import com.codeup.sidework.models.Business;
import com.codeup.sidework.models.User;
import org.springframework.data.repository.CrudRepository;

public interface BusinessesRepository extends CrudRepository<Business, Long> {
    Business findByUser(User user);
}
