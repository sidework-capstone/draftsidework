package com.codeup.sidework.daos;

import com.codeup.sidework.models.Positions;
import org.springframework.data.repository.CrudRepository;

public interface PositionsRepository extends CrudRepository<Positions, Long> {
        Positions findAllByJobTitle(String jobTitle);

    }
