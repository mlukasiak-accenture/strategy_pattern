package com.accenture.workshop.strategy.discounts;

import com.accenture.workshop.strategy.discounts.calculation.model.DiscountModel;
import com.accenture.workshop.strategy.discounts.calculation.strategy.discount.DiscountStrategyFactory;
import com.accenture.workshop.strategy.discounts.calculation.strategy.discount.IDiscountStrategy;
import java.math.BigDecimal;
import java.util.Map;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DiscountHelper {
    private final Map<String, Object> scope;
    private final DiscountStrategyFactory discountStrategyFactory;
    private DiscountCalculationMethod calculationMethod;
    private IDiscountStrategy discountStrategy;

    public BigDecimal calculateDiscount(Map<String, Object> scope) {
        DiscountModel discountModel = getDiscountModel(scope);
        BigDecimal discount = discountStrategy.discount(scope);
        if (isPriceAfterDiscountBelowZero(discountModel.getCurrentPrice(), discount)) {
            discount = discountModel.getCurrentPrice();
        }
        return discount;
    }

    public void setCalculationMethod(DiscountCalculationMethod discountCalculationMethod) {
        this.calculationMethod = discountCalculationMethod;
        this.discountStrategy = discountStrategyFactory.getStrategy(calculationMethod, getDiscountModel(scope));
    }

    private DiscountModel getDiscountModel(Map<String, Object> scope) {
        return (DiscountModel) scope.get(ValueKeys.DISCOUNT_MODEL);
    }

    private boolean isPriceAfterDiscountBelowZero(BigDecimal currentPrice, BigDecimal discount) {
        return currentPrice.subtract(discount).compareTo(BigDecimal.ZERO) < 0;
    }

}
