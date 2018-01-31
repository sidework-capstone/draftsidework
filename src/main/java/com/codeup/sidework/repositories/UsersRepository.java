package com.codeup.sidework.repositories;

import com.codeup.sidework.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
}
