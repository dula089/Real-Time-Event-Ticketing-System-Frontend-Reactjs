package com.example.ticketing.system_backend.service;

import com.example.ticketing.system_backend.model.Log;
import com.example.ticketing.system_backend.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    //save a new log entry to the database
    public Log saveLog(Log log) {
        return logRepository.save(log);
    }
}
