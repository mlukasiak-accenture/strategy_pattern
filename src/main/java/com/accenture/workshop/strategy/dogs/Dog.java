package com.accenture.workshop.strategy.dogs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Dog {

    public abstract void bark();

    public abstract void run();

    public abstract void pet();
}
