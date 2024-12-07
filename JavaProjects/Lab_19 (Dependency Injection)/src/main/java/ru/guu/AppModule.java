package ru.guu;

import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DiscountService.class).to(DiscountServiceImpl.class);
        bind(DiscountStrategy.class).to(DiscountStrategyFactory.class);
    }
}