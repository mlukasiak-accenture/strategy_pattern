package com.accenture.workshop.strategy.discounts.calculation.strategy.retrieval;

import com.accenture.workshop.strategy.discounts.DiscountCalculationMethod;
import com.accenture.workshop.strategy.discounts.ValueKeys;
import com.accenture.workshop.strategy.discounts.calculation.model.DiscountData;
import com.accenture.workshop.strategy.discounts.calculation.model.DiscountModel;
import java.util.Map;

public class StaffDiscountRetrievalStrategy implements IDiscountRetrievalStrategy {
    @Override
    public DiscountData retrieveDiscountModel(Map<String, Object> scope) {
        return  ((DiscountModel)scope.get(ValueKeys.DISCOUNT_MODEL)).getStaffDiscountData();
    }

    @Override
    public boolean isApplicable(DiscountCalculationMethod calculationMethod, DiscountModel discountModel) {
        return !calculationMethod.isUsingPromptAlways() && discountModel.isStaffDiscount();
    }
}
