package com.codeup.sidework.daos;

import com.codeup.sidework.models.User;
import com.codeup.sidework.models.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends CrudRepository<Worker, Long> {
    Worker findByUser(User user);
}
