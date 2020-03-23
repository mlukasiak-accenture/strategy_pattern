package com.accenture.workshop.strategy.dogs;

public class Client {

    public static void main(String[] args) {
        Dog dog = new Wolf();
        dog.bark();
        dog.pet();
        dog.run();
    }
}
