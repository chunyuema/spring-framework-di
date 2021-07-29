package com.chunyue.springframeworkdi.services;

import com.chunyue.springframeworkdi.repositories.EnglishGreetRepository;

public class I18nEnglishGreetingService implements GreetingService {

    private final EnglishGreetRepository englishGreetRepository;

    public I18nEnglishGreetingService(EnglishGreetRepository englishGreetRepository) {
        this.englishGreetRepository = englishGreetRepository;
    }

    @Override
    public String sayGreeting() {
        return englishGreetRepository.getGreeting();
    }
}
