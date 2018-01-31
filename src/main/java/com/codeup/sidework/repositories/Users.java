package com.codeup.sidework.repositories;

import com.codeup.sidework.models.User;
import org.springframework.data.repository.CrudRepository;

public interface Users extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
