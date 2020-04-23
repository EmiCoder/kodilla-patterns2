package com.kodilla.kodillapatterns2.decorator.pizza;

import com.kodilla.kodillapatterns2.com.kodilla.patterns2.decorator.pizza.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {

    @Test
    public  void WithDeliveryGetCost() {
        PizzaOrder order = new Delivery(new ExtraIngredientsDecorator(
                                            new ExtraIngredientsDecorator(
                                                new BasicPizzaOrder(), "ham"), "bacon"));
        Assert.assertEquals(new BigDecimal(42), order.getCost());
    }

    @Test
    public void ExtraIngredientsCost() {
        PizzaOrder order = new ExtraIngredientsDecorator(
                           new ExtraIngredientsDecorator(
                                   new BasicPizzaOrder(), "ham"), "bacon");
        Assert.assertEquals(new BigDecimal(35), order.getCost());
    }

    @Test
    public void ExtraIngredientsGetDescription() {
        PizzaOrder order = new ExtraIngredientsDecorator(
                                new ExtraIngredientsDecorator(
                                    new BasicPizzaOrder(), "ham"), "bacon");
        Assert.assertEquals("Ciasto standard, sos pomidorowy, ser plus extra ingredient: ham plus extra ingredient: bacon", order.getDescription());
    }

    @Test
    public void VegetrianGetCost() {
        PizzaOrder order = new VegetarianDecorator(new BasicPizzaOrder());
        Assert.assertEquals(new BigDecimal(30), order.getCost());
    }

    @Test
    public void VegetrianGetDescription() {
        PizzaOrder order = new VegetarianDecorator(new BasicPizzaOrder());
        Assert.assertEquals("Ciasto standard, sos pomidorowy, ser plus vegetarian ingredients", order.getDescription());
    }
}
