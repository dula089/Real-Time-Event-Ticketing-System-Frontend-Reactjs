package com.example.ticketing.system_backend.controller;

import com.example.ticketing.system_backend.model.Log;
import com.example.ticketing.system_backend.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/logs")
public class LogController {
    @Autowired
    private LogService logService;

    //endpoint to create a new log entry
    @PostMapping
    public Log createLog(@RequestBody Log log) {
        return logService.saveLog(log);
    }
}
