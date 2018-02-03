package com.codeup.sidework.daos;


import com.codeup.sidework.models.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Roles extends CrudRepository<UserRole, Long> {
    @Query("SELECT ur.role FROM UserRole ur, User u WHERE u.username=?1 and ur.userId = u.id ")List<String> ofUserWith(String username);

}
