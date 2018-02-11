package com.codeup.sidework.services;

import com.codeup.sidework.daos.WorkerRepository;
import com.codeup.sidework.models.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("workerSvc")
public class WorkerService {
    private final WorkerRepository workerDao;

    @Autowired
    public WorkerService(WorkerRepository workerDao) {
        this.workerDao = workerDao;
    }

    public List<Worker> searchForWorker(String name) {
        return workerDao.search(name);
    }

}
