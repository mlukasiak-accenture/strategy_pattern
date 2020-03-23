package com.accenture.workshop.strategy.dogs;

import com.accenture.workshop.strategy.dogs.barking.HowlingBarkingBehaviour;
import com.accenture.workshop.strategy.dogs.barking.SmallDogBarkingBehaviour;
import com.accenture.workshop.strategy.dogs.petting.DislikingPettingBehaviour;
import com.accenture.workshop.strategy.dogs.petting.LikingPettingBehaviour;
import com.accenture.workshop.strategy.dogs.running.FastRunningBehaviour;
import com.accenture.workshop.strategy.dogs.running.SlowRunningBehaviour;

public class DogFactory {

    public Dog chihuahua() {
        return new Dog(new SmallDogBarkingBehaviour(), new SlowRunningBehaviour(), new DislikingPettingBehaviour());
    }

    public Dog wolf() {
        return new Dog(new HowlingBarkingBehaviour(), new FastRunningBehaviour(), new DislikingPettingBehaviour());
    }

    public Dog husky() {
        return new Dog(new HowlingBarkingBehaviour(), new FastRunningBehaviour(), new LikingPettingBehaviour());
    }


}
