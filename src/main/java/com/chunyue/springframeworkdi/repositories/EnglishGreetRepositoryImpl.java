package com.chunyue.springframeworkdi.repositories;

public class EnglishGreetRepositoryImpl implements EnglishGreetRepository {
    @Override
    public String getGreeting() {
        return "Hello My beautiful world";
    }
}
