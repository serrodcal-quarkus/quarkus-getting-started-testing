package com.serrodcal;

import io.smallrye.mutiny.Uni;

import javax.inject.Singleton;

@Singleton
public class GreetingService {

    public Uni<String> greet(String name) {
        return Uni.createFrom().item("Hello " + name);
    }

}
