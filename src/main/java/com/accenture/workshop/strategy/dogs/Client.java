package com.accenture.workshop.strategy.dogs;

public class Client {

    public static void main(String[] args) {
        DogFactory dogFactory = new DogFactory();

        Dog dog = dogFactory.wolf();
        playWith(dog);

        Wolf wolf = new Wolf();
        playWith(wolf);
    }

    private static void playWith(Dog dog) {
        dog.bark();
        dog.pet();
        dog.run();
    }
}
