package com.accenture.workshop.strategy.dogs.petting;

public class LikingPettingBehaviour implements IPettingBehaviour {

    @Override
    public void pet() {
        System.out.println("Love it.");
    }
}
