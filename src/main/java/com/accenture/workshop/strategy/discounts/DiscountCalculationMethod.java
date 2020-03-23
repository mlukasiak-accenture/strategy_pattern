package com.accenture.workshop.strategy.discounts;

import lombok.Value;

@Value
public class DiscountCalculationMethod {
    boolean dollarAmountBased;
    boolean usingPromptAlways;
    boolean percentageBased;

    public static DiscountCalculationMethod NONE_Surcharge = new DiscountCalculationMethod();

}
