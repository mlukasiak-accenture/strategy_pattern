package com.accenture.workshop.strategy.dogs;

import com.accenture.workshop.strategy.dogs.barking.IBarkingBehaviour;
import com.accenture.workshop.strategy.dogs.petting.IPettingBehaviour;
import com.accenture.workshop.strategy.dogs.running.IRunningBehaviour;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class Dog {
    private IBarkingBehaviour barkingBehaviour;
    private IRunningBehaviour runningBehaviour;
    private IPettingBehaviour pettingBehaviour;

    public final void bark() {
        barkingBehaviour.bark();
    };

    public final void run() {
        runningBehaviour.run();
    }

    public final void pet() {
        pettingBehaviour.pet();
    }
}
