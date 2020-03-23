package com.accenture.workshop.strategy.dogs.running;

public class SlowRunningBehaviour implements IRunningBehaviour {

    @Override
    public void run() {
        System.out.println("Wait for me...");
    }
}
