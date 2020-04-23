package com.kodilla.kodillapatterns2.decorator.taxiportal;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TaxiOrderTestSuite {

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {
            TaxiOrder taxiOrder = new ChildSeatDecorator(new VipDecorator(new TaxiNetworkOrderDecorator(new BasicTaxiOrder())));
            Assert.assertEquals(new BigDecimal(52), taxiOrder.getCost());
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {
        TaxiOrder taxiOrder = new ChildSeatDecorator(new VipDecorator(new TaxiNetworkOrderDecorator(new BasicTaxiOrder())));
        Assert.assertEquals("Drive a course by Taxi Network plus variant VIP plus child set", taxiOrder.getDescription());
    }

    @Test
    public void testMyTaxiWithChildSeatGetCost() {
        TaxiOrder taxiOrder = new ChildSeatDecorator(
                                    new ChildSeatDecorator(
                                    new MyTaxiNetworkOrderDecorator(
                                    new BasicTaxiOrder())));
        Assert.assertEquals(new BigDecimal(39), taxiOrder.getCost());
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription() {
        TaxiOrder taxiOrder = new ChildSeatDecorator(new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder()));
        Assert.assertEquals("Drive a course by MyTaxi Network plus child set", taxiOrder.getDescription());
    }

    @Test
    public void testTaxiNetworkGetCost() {
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        Assert.assertEquals(new BigDecimal(40), taxiOrder.getCost());
    }

    @Test
    public void testTaxiNetworkGetDescription() {
        TaxiOrder taxiOrder = new TaxiNetworkOrderDecorator(new BasicTaxiOrder());
        Assert.assertEquals("Drive a course by Taxi Network", taxiOrder.getDescription());
    }

    @Test
    public void testBasicTaxiOrderGetCost() {
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        BigDecimal calculatedCost = taxiOrder.getCost();
        Assert.assertEquals(new BigDecimal(5), calculatedCost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        String desc = taxiOrder.getDescription();
        Assert.assertEquals("Drive a course", desc);
    }
}
