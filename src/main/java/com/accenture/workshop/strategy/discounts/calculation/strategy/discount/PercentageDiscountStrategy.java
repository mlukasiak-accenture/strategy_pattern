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
public class PercentageDiscountStrategy implements IDiscountStrategy {
    @With
    private final IDiscountRetrievalStrategy retrievalStrategy;

    @Override
    public boolean isApplicable(DiscountCalculationMethod discountCalculationMethod) {
        return discountCalculationMethod.isPercentageBased();
    }

    @Override
    public BigDecimal discount(Map<String, Object> context) {
        BigDecimal discount = retrievalStrategy.retrieveDiscountModel(context).getDiscountPercent();
        DiscountModel discountModel = ((DiscountModel) context.get(ValueKeys.DISCOUNT_MODEL));

        BigDecimal price = discountModel.getCurrentPrice();
        if (discountModel.isStaffDiscount() && isFullPriceNotZero(discountModel)) {
            price = discountModel.getFullPrice();
        }
        return price.multiply(discount);
    }

    private boolean isFullPriceNotZero(DiscountModel discountModel) {
        return discountModel.getFullPrice() != null && !BigDecimal.ZERO.equals(discountModel.getFullPrice());
    }

}
