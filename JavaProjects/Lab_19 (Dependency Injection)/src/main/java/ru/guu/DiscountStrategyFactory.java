package ru.guu;

import com.google.inject.Inject;

import java.util.HashMap;
import java.util.Map;

public class DiscountStrategyFactory implements DiscountStrategy {

    private final Map<String, DiscountStrategy> strategyMap;

    @Inject
    public DiscountStrategyFactory() {
        this.strategyMap = new HashMap<>();
        strategyMap.put("Без скидки", new NoDiscountStrategy());
        strategyMap.put("Проц. скидка", new PercentageDiscountStrategy());
        strategyMap.put("Фикс. скидка", new FixedDiscountStrategy());
    }

    @Override
    public double applyDiscount(double cost) {
        throw new UnsupportedOperationException("Используйте calculateCost в DiscountService!");
    }

    public DiscountStrategy getStrategy(String discountType) {
        return strategyMap.getOrDefault(discountType, new NoDiscountStrategy());
    }
}
