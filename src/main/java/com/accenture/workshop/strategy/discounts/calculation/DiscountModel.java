package com.accenture.workshop.strategy.discounts.calculation;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DiscountModel {
    private boolean staffDiscount;
    private DiscountData staffDiscountData;
    private DiscountData itemDiscountData;
    private BigDecimal currentPrice;
    private BigDecimal fullPrice;
    private boolean simAutoDiscountApplicable;
}
