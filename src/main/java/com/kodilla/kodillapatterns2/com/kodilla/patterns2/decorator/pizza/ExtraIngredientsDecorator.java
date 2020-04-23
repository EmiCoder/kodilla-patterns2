package com.kodilla.kodillapatterns2.com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraIngredientsDecorator extends AbstractPizzaOrderDecorator {

    private final String ingredient;

    public ExtraIngredientsDecorator(PizzaOrder pizzaOrder, String ingredient) {
        super(pizzaOrder);
        this.ingredient = ingredient;
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(10));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " plus extra ingredient: " + ingredient;
    }
}
