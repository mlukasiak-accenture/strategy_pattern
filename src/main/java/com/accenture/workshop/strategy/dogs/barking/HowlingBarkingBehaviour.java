package com.accenture.workshop.strategy.dogs.barking;

public class HowlingBarkingBehaviour implements IBarkingBehaviour {

    @Override
    public void bark() {
        System.out.println("... hauuuuuuuuuuuuuuuuuuuuuu");
    }
}
