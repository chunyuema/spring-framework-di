package com.chunyue.springframeworkdi.controllers;

import com.chunyue.springframeworkdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectedControllerTest {

    SetterInjectedController controller;

    @BeforeEach
    void setUp() {
        controller= new SetterInjectedController();
        controller.setGreetingService(new ConstructorGreetingService());
    }

    @Test
    void sayGreeting() {
        System.out.println(controller.getGreeting());
    }
}