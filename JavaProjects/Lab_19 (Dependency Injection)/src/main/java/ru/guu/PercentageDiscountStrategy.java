package ru.guu;

public class PercentageDiscountStrategy implements DiscountStrategy {
    private final double percentage = 10.0; // Для примера 10%

    @Override
    public double applyDiscount(double cost) {
        return cost - (cost * (percentage / 100));
    }
}