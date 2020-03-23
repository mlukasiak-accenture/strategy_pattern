package com.accenture.workshop.strategy.dogs;

import com.accenture.workshop.strategy.dogs.barking.HowlingBarkingBehaviour;
import com.accenture.workshop.strategy.dogs.running.FastRunningBehaviour;

public class Wolf extends Dog {

    public Wolf() {
        super(new HowlingBarkingBehaviour(), new FastRunningBehaviour(), () -> System.out.println("Don't even try..."));
    }

}
