package com.chunyue.springframeworkdi.config;

import com.chunyue.pets.PetService;
import com.chunyue.pets.PetServiceFactory;
import com.chunyue.springframeworkdi.datasource.MockDataSource;
import com.chunyue.springframeworkdi.repositories.EnglishGreetRepository;
import com.chunyue.springframeworkdi.repositories.EnglishGreetRepositoryImpl;
import com.chunyue.springframeworkdi.services.ConstructorGreetingService;
import com.chunyue.springframeworkdi.services.I18nEnglishGreetingService;
import com.chunyue.springframeworkdi.services.I18nSpanishGreetingService;
import com.chunyue.springframeworkdi.services.PrimaryGreetingService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;


// Using the java configuration can allow us to get rid of the @Service component annotation
// Another way to declare configure the spring component for it to be picked up
@Configuration
//@PropertySource("classpath:datasource.properties") // this is not necessary if we depend on spring boot, which
// automatically scan the application.properties file
@EnableConfigurationProperties(ConstructorConfig.class)
public class GreetingServiceConfig {
    // let sring inject this springframworkconfig bean
    @Bean
    MockDataSource mockDataSource(ConstructorConfig constructorConfig){
        MockDataSource mockDataSource = new MockDataSource();
        mockDataSource.setUsername(constructorConfig.getUsername());
        mockDataSource.setPassword(constructorConfig.getPassword());
        mockDataSource.setJdbcurl(constructorConfig.getJdbcurl());
        return mockDataSource;
    }

    @Bean
    EnglishGreetRepository englishGreetRepository(){
        return new EnglishGreetRepositoryImpl();
    }

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

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService I18nService(EnglishGreetRepository englishGreetRepository){
        return new I18nEnglishGreetingService(englishGreetRepository);
    }

    @Profile({"ES", "default"})
    @Bean("I18nService") // need to manually rename it since this cannot be directly again in the same java class
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }
}

