package com.kodilla.kodillapatterns2.com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class Delivery extends AbstractPizzaOrderDecorator {

    public Delivery(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(7));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " plus delivery";
    }
}
