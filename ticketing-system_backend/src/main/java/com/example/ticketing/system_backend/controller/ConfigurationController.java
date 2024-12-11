package com.example.ticketing.system_backend.controller;

import com.example.ticketing.system_backend.model.Configuration;
import com.example.ticketing.system_backend.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/configuration")
public class ConfigurationController {
    private final ConfigurationService configurationService;

    @Autowired
    public ConfigurationController(ConfigurationService configurationService){
        this.configurationService=configurationService;
    }

    @PostMapping
    public ResponseEntity<Configuration> saveConfiguration(@RequestBody Configuration configuration){
        Configuration savedConfiguration=configurationService.saveConfiguration(configuration);
        return new ResponseEntity<>(savedConfiguration, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Configuration>getConfiguration(@PathVariable Long id){
        Configuration configuration=configurationService.getConfiguration(id);
        return configuration!=null?
                new ResponseEntity<>(configuration,HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
