package ru.guu;

public class FixedDiscountStrategy implements DiscountStrategy {
    private final double fixedDiscount = 20.0; // Для примера будет 20 рублей

    @Override
    public double applyDiscount(double cost) {
        return Math.max(0, cost - fixedDiscount);
    }
}