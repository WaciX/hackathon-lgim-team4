package com.lgim.hackathon.team4;

import io.quarkus.funqy.Funq;

import javax.inject.Inject;

public class GreetingFunction {
    @Inject
    GreetingService service;

    @Funq
    public Greeting greet(Friend friend) {
        Greeting greeting = new Greeting();
        greeting.setMessage(service.greet(friend.getName()));
        return greeting;
    }
}
