package com.accenture.workshop.strategy.dogs.petting;

public class DislikingPettingBehaviour implements IPettingBehaviour {

    @Override
    public void pet() {
        System.out.println("Bite me ...");
    }
}
