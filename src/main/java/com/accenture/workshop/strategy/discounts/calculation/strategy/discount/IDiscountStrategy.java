package com.accenture.workshop.strategy.discounts.calculation.strategy.discount;

import com.accenture.workshop.strategy.discounts.DiscountCalculationMethod;
import com.accenture.workshop.strategy.discounts.calculation.strategy.retrieval.IDiscountRetrievalStrategy;
import java.math.BigDecimal;
import java.util.Map;

public interface IDiscountStrategy {
    boolean isApplicable(DiscountCalculationMethod discountCalculationMethod);

    BigDecimal discount(Map<String, Object> context);

    IDiscountStrategy withRetrievalStrategy(IDiscountRetrievalStrategy retrievalStrategy);
}
