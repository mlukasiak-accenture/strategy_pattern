package com.accenture.workshop.strategy.discounts;

import com.accenture.workshop.strategy.discounts.calculation.DiscountData;
import com.accenture.workshop.strategy.discounts.calculation.DiscountModel;
import com.accenture.workshop.strategy.discounts.calculation.strategy.discount.DiscountStrategyFactory;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class DiscountHelperTest {

    @Test
    public void testAutoDiscount() {
        DiscountModel model = DiscountModel.builder()
                .staffDiscount(false)
                .staffDiscountData(DiscountData.builder().discountAmount(new BigDecimal("3.3")).discountPercent(new BigDecimal("0.11")).build())
                .itemDiscountData(DiscountData.builder().discountAmount(new BigDecimal("2.4")).discountPercent(new BigDecimal("0.14")).build())
                .currentPrice(new BigDecimal("100"))
                .fullPrice(new BigDecimal("110"))
                .simAutoDiscountApplicable(false)
                .build();

        Map<String, Object> transactionScope = new HashMap<>();
        transactionScope.put(ValueKeys.ENTERED_DISCOUNT_DATA, DiscountData.builder().discountAmount(new BigDecimal("3")).discountPercent(new BigDecimal("0.10")).build());
        transactionScope.put(ValueKeys.DISCOUNT_MODEL, model);

        DiscountHelper helper = new DiscountHelper(transactionScope, new DiscountStrategyFactory());
        helper.setCalculationMethod(DiscountCalculationMethod.PERCENT_AUTO);

        BigDecimal discountValue = helper.calculateDiscount(transactionScope);
        System.out.println(discountValue);
        assertThat(discountValue).
    }

}