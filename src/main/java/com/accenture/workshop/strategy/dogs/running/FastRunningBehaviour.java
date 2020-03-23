package com.accenture.workshop.strategy.dogs.running;

public class FastRunningBehaviour implements IRunningBehaviour {
    @Override
    public void run() {
        System.out.println("Try to catch me.");
    }
}
