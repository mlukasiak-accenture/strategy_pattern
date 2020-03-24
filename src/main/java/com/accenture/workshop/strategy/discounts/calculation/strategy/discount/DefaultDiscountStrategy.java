package com.accenture.workshop.strategy.discounts.calculation.strategy.discount;

import com.accenture.workshop.strategy.discounts.DiscountCalculationMethod;
import com.accenture.workshop.strategy.discounts.calculation.strategy.retrieval.IDiscountRetrievalStrategy;
import java.math.BigDecimal;
import java.util.Map;

public class DefaultDiscountStrategy implements IDiscountStrategy {

    @Override
    public boolean isApplicable(DiscountCalculationMethod discountCalculationMethod) {
        return true;
    }

    @Override
    public BigDecimal discount(Map<String, Object> context) {
        return BigDecimal.ZERO;
    }

    @Override
    public IDiscountStrategy withRetrievalStrategy(IDiscountRetrievalStrategy retrievalStrategy) {
        return this;
    }
}
