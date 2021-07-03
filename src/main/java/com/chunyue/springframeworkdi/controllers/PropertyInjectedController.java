package com.chunyue.springframeworkdi.controllers;

import com.chunyue.springframeworkdi.services.GreetingService;

public class PropertyInjectedController {
    public GreetingService greetingService;

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
