package com.accenture.workshop.strategy.discounts;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class DiscountHelper {
    private boolean staffDiscount;
    private BigDecimal staffDiscountAmount;
    private BigDecimal discountAmount;
    private BigDecimal staffDiscountPercent;
    private BigDecimal discountPercent;
    private BigDecimal fullItemPrice;
    private boolean simAutoDiscountApplicable;

    private BigDecimal valueForCalc = null;

    private DiscountCalculationMethod calculationMethod;
    private Map<String, Object> transactionScope = new HashMap<>();

    public BigDecimal prepareDiscountValue(BigDecimal currentPrice, BigDecimal fullPrice) {
        // calc method
        if (calculationMethod == DiscountCalculationMethod.NONE_Surcharge) {
            valueForCalc = (BigDecimal) transactionScope.get(ValueKeys.ENTERED_DISCOUNT_AMOUNT);
            return valueForCalc.negate();
        }

        // calc method
        if (calculationMethod.isDollarAmountBased()) {
            if (!calculationMethod.isUsingPromptAlways()) {
                valueForCalc = isStaffDiscount() ? getStaffDiscountAmount() : getDiscountAmount();
            } else {
                valueForCalc = (BigDecimal) transactionScope.get(ValueKeys.ENTERED_DISCOUNT_AMOUNT);
                if (isSimAutoDiscountApplicable() || isPriceAfterDiscountBelowZero(currentPrice)) {
                    valueForCalc = currentPrice;
                }
            }
            return valueForCalc;
        }

        // calc method
        if (calculationMethod.isPercentageBased()) {
            if ((!calculationMethod.isUsingPromptAlways())) {
                valueForCalc = isStaffDiscount() ? getStaffDiscountPercent() : getDiscountPercent();
            } else {
                valueForCalc = (BigDecimal) transactionScope.get(ValueKeys.ENTERED_DISCOUNT_PERCENT);
            }
            if (isStaffDiscount() && !isFullPriceNull() && !isFullPriceZero()) {
                return fullPrice.multiply(valueForCalc);
            }
            return currentPrice.multiply(valueForCalc);
        }

        //def
        return BigDecimal.valueOf(0);
    }

    private boolean isPriceAfterDiscountBelowZero(BigDecimal currentPrice) {
        return currentPrice.subtract(valueForCalc).compareTo(BigDecimal.ZERO) < 0;
    }

    private boolean isFullPriceZero() {
        return 0 == getFullItemPrice().compareTo(BigDecimal.ZERO);
    }

    private boolean isFullPriceNull() {
        return null == getFullItemPrice();
    }

}
