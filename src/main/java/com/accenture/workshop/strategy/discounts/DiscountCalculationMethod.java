package com.accenture.workshop.strategy.discounts;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class DiscountCalculationMethod {
    boolean dollarAmountBased;
    boolean usingPromptAlways;
    boolean percentageBased;

    public static final DiscountCalculationMethod NONE_Surcharge = new DiscountCalculationMethod(true, true, false);
    public static final DiscountCalculationMethod PERCENT = new DiscountCalculationMethod(false, true, true);
    public static final DiscountCalculationMethod AMOUNT = new DiscountCalculationMethod(true, true, false);
    public static final DiscountCalculationMethod PERCENT_AUTO = new DiscountCalculationMethod(false, false, true);
    public static final DiscountCalculationMethod AMOUNT_AUTO = new DiscountCalculationMethod(true, false, false);

}
