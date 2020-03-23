package com.accenture.workshop.strategy.dogs.barking;

public class SmallDogBarkingBehaviour implements IBarkingBehaviour {
    @Override
    public void bark() {
        System.out.println("Rark, rark, rark");
    }
}
