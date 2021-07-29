package com.chunyue.springframeworkdi.config;

import com.chunyue.springframeworkdi.services.ConstructorGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// Using the configuration can allow us to get rid of the @Service component annotation
// Another way to declare configure the spring component for it to be picked up
@Configuration
public class GreetingServiceConfig {
    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }
}

