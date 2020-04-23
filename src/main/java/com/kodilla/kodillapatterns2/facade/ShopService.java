package com.kodilla.kodillapatterns2.facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class ShopService {

    private final List<Order> orders = new ArrayList<>();
    @Autowired
    private Authenticator authenticator;
    @Autowired
    private ProductService productService;

    public Long openOrder(Long userId) {
        if (authenticator.isAuthenticated(userId)) {
            Long maxOrder = (long) orders.stream()
                                .mapToInt(o ->o.getOrderId().intValue())
                                .max().orElse(0);
            orders.add(new Order(productService, maxOrder + 1, userId));
            return maxOrder + 1;
        }
        return -1L;
    }

    public void addItem(long orderId, Long productId, double qty) {
            orders.stream()
                    .filter(o -> o.getOrderId().equals(orderId))
                    .forEach(o -> o.getItems().add(new Item(productId, qty)));
    }

    public boolean removeItem(Long orderId, Long productId) {
            Iterator<Order> orderIterator = orders.stream()
                                                    .filter(o-> o.getOrderId().equals(orderId)).iterator();

            while (orderIterator.hasNext()) {
                Order currentOrder = orderIterator.next();
                int amountOfCurrentOrderItems = currentOrder.getItems().size();
                for (int i = 0; i < amountOfCurrentOrderItems; i++) {
                    if (currentOrder.getItems().get(i).getProductId().equals(productId)) {
                            currentOrder.getItems().remove(i);
                            return true;
                    }
                }
            } return false;
    }


    public BigDecimal calculateValue(Long orderId) {
            Iterator<Order> orderIterator = orders.stream()
                    .filter(o-> o.getOrderId().equals(orderId)).iterator();

            while (orderIterator.hasNext()) {
                return orderIterator.next().calculateValue();
            } return BigDecimal.ZERO;
    }

    public boolean doPayment(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o-> o.getOrderId().equals(orderId)).iterator();

        while (orderIterator.hasNext()) {
            if (orderIterator.next().isPaid()) {
                return true;
            } else {
                Random generator = new Random();
                orderIterator.next().setPaid(generator.nextBoolean());
                return orderIterator.next().isPaid();
            }
        } return false;
    }

    public boolean verifyOrder(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o-> o.getOrderId().equals(orderId)).iterator();

        while (orderIterator.hasNext()) {
            Order currentOrder = orderIterator.next();
            Random generator = new Random();

            if (!currentOrder.isVerified()) {
                currentOrder.setVerified(currentOrder.isPaid() && generator.nextBoolean());
            }
            return currentOrder.isVerified();
        } return false;
    }

    public boolean submitOrder(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o-> o.getOrderId().equals(orderId)).iterator();

        while (orderIterator.hasNext()) {
            if (orderIterator.next().isVerified()) {
                    orderIterator.next().setSubmitted(true);
            } return orderIterator.next().isSubmitted();
        } return false;
    }

    public void cancelOrder(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o-> o.getOrderId().equals(orderId)).iterator();

        while (orderIterator.hasNext()) {
            orders.remove(orderIterator.next());
        }
    }
}
