package com.accenture.workshop.strategy.discounts.calculation.strategy.discount;

import com.accenture.workshop.strategy.discounts.DiscountCalculationMethod;
import com.accenture.workshop.strategy.discounts.ValueKeys;
import com.accenture.workshop.strategy.discounts.calculation.DiscountModel;
import com.accenture.workshop.strategy.discounts.calculation.strategy.retrieval.IDiscountRetrievalStrategy;
import java.math.BigDecimal;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.With;

@RequiredArgsConstructor
public class AmountDiscountStrategy implements IDiscountStrategy {
    @With
    private final IDiscountRetrievalStrategy retrievalStrategy;

    @Override
    public boolean isApplicable(DiscountCalculationMethod discountCalculationMethod) {
        return discountCalculationMethod.isDollarAmountBased();
    }

    @Override
    public BigDecimal discount(Map<String, Object> context) {
        BigDecimal discount = retrievalStrategy.retrieveDiscountModel(context).getDiscountAmount();
        DiscountModel discountModel = ((DiscountModel) context.get(ValueKeys.DISCOUNT_MODEL));
        if (discountModel.isSimAutoDiscountApplicable()) {
            discount = discountModel.getCurrentPrice();
        }
        return discount;
    }
}
