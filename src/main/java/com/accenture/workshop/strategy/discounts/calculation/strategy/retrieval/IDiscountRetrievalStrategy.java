package com.accenture.workshop.strategy.discounts.calculation.strategy.retrieval;

import com.accenture.workshop.strategy.discounts.DiscountCalculationMethod;
import com.accenture.workshop.strategy.discounts.calculation.model.DiscountData;
import com.accenture.workshop.strategy.discounts.calculation.model.DiscountModel;
import java.util.Map;

public interface IDiscountRetrievalStrategy {
    DiscountData retrieveDiscountModel(Map<String, Object> scope);

    boolean isApplicable(DiscountCalculationMethod discountCalculationMethod, DiscountModel discountModel);
}
