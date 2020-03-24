package com.accenture.workshop.strategy.discounts.calculation;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DiscountData {
    BigDecimal discountPercent;
    BigDecimal discountAmount;
}
