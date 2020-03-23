package com.accenture.workshop.strategy.dogs;

public class Husky extends Dog {

    @Override
    public void bark() {
        System.out.println("... hauuuuuuuuuuuuuuuuuuuuuu");
    }

    @Override
    public void run() {
        System.out.println("Try to catch me.");
    }

    @Override
    public void pet() {
        System.out.println("Love it.");
    }
}
