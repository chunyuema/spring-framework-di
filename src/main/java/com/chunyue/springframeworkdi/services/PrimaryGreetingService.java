package com.chunyue.springframeworkdi.services;

public class PrimaryGreetingService implements GreetingService {
    @Override
    public String sayGreeting(){
        return "Hello World from the primary bean";
    }
}
