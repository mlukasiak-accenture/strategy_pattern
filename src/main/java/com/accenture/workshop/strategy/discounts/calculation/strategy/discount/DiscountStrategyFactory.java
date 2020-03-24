package com.accenture.workshop.strategy.discounts.calculation.strategy.discount;

import com.accenture.workshop.strategy.discounts.DiscountCalculationMethod;
import com.accenture.workshop.strategy.discounts.calculation.model.DiscountModel;
import com.accenture.workshop.strategy.discounts.calculation.strategy.retrieval.DiscountRetrievalStrategyFactory;
import com.accenture.workshop.strategy.discounts.calculation.strategy.retrieval.IDiscountRetrievalStrategy;
import com.accenture.workshop.strategy.discounts.calculation.strategy.retrieval.PromptDiscountRetrievalStrategy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DiscountStrategyFactory {
    private static final IDiscountStrategy DEFAULT_STRATEGY = new DefaultDiscountStrategy();
    private static final IDiscountRetrievalStrategy DEFAULT_RETRIEVAL_STRATEGY = new PromptDiscountRetrievalStrategy();
    private Set<IDiscountStrategy> strategies = new HashSet<>();
    private DiscountRetrievalStrategyFactory retrievalStrategyFactory = new DiscountRetrievalStrategyFactory();

    public DiscountStrategyFactory() {
        strategies.addAll(Arrays.asList(new SurchargeDiscountStrategy(),
                new AmountDiscountStrategy(DEFAULT_RETRIEVAL_STRATEGY),
                new PercentageDiscountStrategy(DEFAULT_RETRIEVAL_STRATEGY)));
    }

    public IDiscountStrategy getStrategy(DiscountCalculationMethod calculationMethod, DiscountModel discountModel) {
        return strategies.stream()
                .filter(strategy -> strategy.isApplicable(calculationMethod))
                .findFirst()
                .orElse(DEFAULT_STRATEGY)
                .withRetrievalStrategy(retrievalStrategyFactory.getStrategy(calculationMethod, discountModel));
    }
}
