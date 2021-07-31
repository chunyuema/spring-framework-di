package com.chunyue.springframeworkdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("Creating a singleton bean");
    }

    public String getMyScope(){
        return "I am a singleton";
    }
}
