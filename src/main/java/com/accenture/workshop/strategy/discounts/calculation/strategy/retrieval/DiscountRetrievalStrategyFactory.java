package com.accenture.workshop.strategy.discounts.calculation.strategy.retrieval;

import com.accenture.workshop.strategy.discounts.DiscountCalculationMethod;
import com.accenture.workshop.strategy.discounts.calculation.model.DiscountModel;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DiscountRetrievalStrategyFactory {
    private Set<IDiscountRetrievalStrategy> strategies = new HashSet<>();

    public DiscountRetrievalStrategyFactory() {
        strategies.addAll(Arrays.asList(new PromptDiscountRetrievalStrategy(),
                new NonPromptDiscountRetrievalStrategy(),
                new StaffDiscountRetrievalStrategy()));
    }

    public IDiscountRetrievalStrategy getStrategy(DiscountCalculationMethod calculationMethod, DiscountModel discountModel) {
        return strategies.stream()
                .filter(strategy -> strategy.isApplicable(calculationMethod, discountModel))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown data retrieval strategy"));
    }
}
