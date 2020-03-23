package com.accenture.workshop.strategy.dogs;

public class Chihuahua extends Dog {

    @Override
    public void bark() {
        System.out.println("Rark, rark, rark");
    }

    @Override
    public void run() {
        System.out.println("Wait for me...");
    }

    @Override
    public void pet() {
        System.out.println("Bite me ...");
    }
}
