package ru.guu;

import com.google.inject.Inject;

public class DiscountServiceImpl implements DiscountService {

    private final DiscountStrategyFactory strategyFactory;

    @Inject
    public DiscountServiceImpl(DiscountStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    @Override
    public double calculateCost(double cost, String discountType) {
        DiscountStrategy strategy = strategyFactory.getStrategy(discountType);
        return strategy.applyDiscount(cost);
    }
}
