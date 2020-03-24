package com.accenture.workshop.strategy.discounts;

import com.accenture.workshop.strategy.discounts.calculation.model.DiscountData;
import com.accenture.workshop.strategy.discounts.calculation.model.DiscountModel;
import com.accenture.workshop.strategy.discounts.calculation.strategy.discount.DiscountStrategyFactory;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class DiscountHelperTest {

    public static final String PERCENT_AUTO = "0.14";
    private static final String EXPECTED_PERCENT_AUTO = "14.00";
    private static final String EXPECTED_AMOUNT_AUTO = "2.40";
    private static final String EXPECTED_AMOUNT_STAFF = "3.3";
    private static final String PERCENT_STAFF = "0.11";
    private static final String EXPECTED_PERCENT_STAFF = "12.10";


    @Test
    public void testAutoPercentageDiscount() {
        DiscountModel model = getDiscountModel(false, false);
        Map<String, Object> transactionScope = getScope(model);

        DiscountHelper helper = getDiscountHelper(transactionScope, DiscountCalculationMethod.PERCENT_AUTO);

        BigDecimal discountValue = helper.calculateDiscount(transactionScope);
        assertThat(discountValue).isEqualTo(EXPECTED_PERCENT_AUTO);
    }

    @Test
    public void testAutoStaffPercentageDiscount() {
        DiscountModel model = getDiscountModel(true, false);
        Map<String, Object> transactionScope = getScope(model);

        DiscountHelper helper = getDiscountHelper(transactionScope, DiscountCalculationMethod.PERCENT_AUTO);

        BigDecimal discountValue = helper.calculateDiscount(transactionScope);
        assertThat(discountValue).isEqualTo(EXPECTED_PERCENT_STAFF);
    }

    @Test
    public void testAutoAmountDiscount() {
        DiscountModel model = getDiscountModel(false, false);
        Map<String, Object> transactionScope = getScope(model);

        DiscountHelper helper = getDiscountHelper(transactionScope, DiscountCalculationMethod.AMOUNT_AUTO);

        BigDecimal discountValue = helper.calculateDiscount(transactionScope);
        assertThat(discountValue).isEqualTo(EXPECTED_AMOUNT_AUTO);
    }

    @Test
    public void testAutoStaffAmountDiscount() {
        DiscountModel model = getDiscountModel(true, false);
        Map<String, Object> transactionScope = getScope(model);

        DiscountHelper helper = getDiscountHelper(transactionScope, DiscountCalculationMethod.AMOUNT_AUTO);

        BigDecimal discountValue = helper.calculateDiscount(transactionScope);
        assertThat(discountValue).isEqualTo(EXPECTED_AMOUNT_STAFF);
    }

    private DiscountHelper getDiscountHelper(Map<String, Object> transactionScope, DiscountCalculationMethod method) {
        DiscountHelper helper = new DiscountHelper(transactionScope, new DiscountStrategyFactory());
        helper.setCalculationMethod(method);
        return helper;
    }

    private Map<String, Object> getScope(DiscountModel model) {
        Map<String, Object> transactionScope = new HashMap<>();
        transactionScope.put(ValueKeys.ENTERED_DISCOUNT_DATA, DiscountData.builder().discountAmount(new BigDecimal("3")).discountPercent(new BigDecimal("0.10")).build());
        transactionScope.put(ValueKeys.DISCOUNT_MODEL, model);
        return transactionScope;
    }

    private DiscountModel getDiscountModel(boolean staffDiscount, boolean simAutoDiscount) {
        return DiscountModel.builder()
                    .staffDiscount(staffDiscount)
                    .staffDiscountData(DiscountData.builder().discountAmount(new BigDecimal(EXPECTED_AMOUNT_STAFF)).discountPercent(new BigDecimal(PERCENT_STAFF)).build())
                    .itemDiscountData(DiscountData.builder().discountAmount(new BigDecimal(EXPECTED_AMOUNT_AUTO)).discountPercent(new BigDecimal(PERCENT_AUTO)).build())
                    .currentPrice(new BigDecimal("100"))
                    .fullPrice(new BigDecimal("110"))
                    .simAutoDiscountApplicable(simAutoDiscount)
                    .build();
    }

}