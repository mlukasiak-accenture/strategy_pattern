package com.accenture.workshop.strategy.discounts.calculation.strategy.retrieval;

import com.accenture.workshop.strategy.discounts.DiscountCalculationMethod;
import com.accenture.workshop.strategy.discounts.ValueKeys;
import com.accenture.workshop.strategy.discounts.calculation.model.DiscountData;
import com.accenture.workshop.strategy.discounts.calculation.model.DiscountModel;
import java.util.Map;

public class PromptDiscountRetrievalStrategy implements IDiscountRetrievalStrategy {
    @Override
    public DiscountData retrieveDiscountModel(Map<String, Object> scope) {
        return ((DiscountData) scope.get(ValueKeys.ENTERED_DISCOUNT_DATA));
    }

    @Override
    public boolean isApplicable(DiscountCalculationMethod discountCalculationMethod, DiscountModel discountModel) {
        return discountCalculationMethod.isUsingPromptAlways();
    }
}
