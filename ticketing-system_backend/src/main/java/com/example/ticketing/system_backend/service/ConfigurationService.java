package com.example.ticketing.system_backend.service;

import com.example.ticketing.system_backend.model.Configuration;
import com.example.ticketing.system_backend.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {
    private final ConfigurationRepository configurationRepository;

    @Autowired
    public ConfigurationService(ConfigurationRepository configurationRepository){
        this.configurationRepository=configurationRepository;
    }
    public Configuration saveConfiguration(Configuration configuration){
        return configurationRepository.save(configuration);
    }
    public Configuration getConfiguration(Long id){
        return configurationRepository.findById(id).orElse(null);
    }
}
