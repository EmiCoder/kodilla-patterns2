package com.kodilla.kodillapatterns2.com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class VegetarianDecorator extends AbstractPizzaOrderDecorator {

    public VegetarianDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(15));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " plus vegetarian ingredients";
    }
}
