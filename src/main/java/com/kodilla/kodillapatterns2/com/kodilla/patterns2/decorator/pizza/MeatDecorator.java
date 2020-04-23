package com.kodilla.kodillapatterns2.com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MeatDecorator extends AbstractPizzaOrderDecorator {

    public MeatDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(25));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " plus meat ingredients";
    }
}
