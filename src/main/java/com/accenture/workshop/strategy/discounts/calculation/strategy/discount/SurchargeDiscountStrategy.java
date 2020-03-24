package com.accenture.workshop.strategy.discounts.calculation.strategy.discount;

import com.accenture.workshop.strategy.discounts.DiscountCalculationMethod;
import com.accenture.workshop.strategy.discounts.ValueKeys;
import com.accenture.workshop.strategy.discounts.calculation.DiscountData;
import com.accenture.workshop.strategy.discounts.calculation.strategy.retrieval.IDiscountRetrievalStrategy;
import java.math.BigDecimal;
import java.util.Map;

public class SurchargeDiscountStrategy implements IDiscountStrategy {

    @Override
    public boolean isApplicable(DiscountCalculationMethod discountCalculationMethod) {
        return discountCalculationMethod == DiscountCalculationMethod.NONE_Surcharge;
    }

    @Override
    public BigDecimal discount(Map<String, Object> context) {
        return ((DiscountData)context.get(ValueKeys.ENTERED_DISCOUNT_DATA)).getDiscountAmount().negate();
    }

    @Override
    public IDiscountStrategy withRetrievalStrategy(IDiscountRetrievalStrategy retrievalStrategy) {
        return this;
    }
}
