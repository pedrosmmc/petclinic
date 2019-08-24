package com.pedrocoelho.learningspringframework.config;

import com.pedrocoelho.learningspringframework.services.map.OwnerServiceMap;
import com.pedrocoelho.learningspringframework.services.map.PetServiceMap;
import com.pedrocoelho.learningspringframework.services.map.VetServiceMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfiguration {
    @Bean
    public OwnerServiceMap ownerServiceMap() {
        return new OwnerServiceMap();
    }

    @Bean
    public VetServiceMap vetServiceMap() {
        return new VetServiceMap();
    }

    @Bean
    public PetServiceMap petServiceMap() {
        return new PetServiceMap();
    }
}
