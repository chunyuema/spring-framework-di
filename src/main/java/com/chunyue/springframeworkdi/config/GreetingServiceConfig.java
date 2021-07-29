package com.chunyue.springframeworkdi.config;

import com.chunyue.springframeworkdi.services.ConstructorGreetingService;
import com.chunyue.springframeworkdi.services.PrimaryGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


// Using the java configuration can allow us to get rid of the @Service component annotation
// Another way to declare configure the spring component for it to be picked up
@Configuration
public class GreetingServiceConfig {
    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    // use the primary annotation here if you would like to configure a component as the primary component
    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }
}

