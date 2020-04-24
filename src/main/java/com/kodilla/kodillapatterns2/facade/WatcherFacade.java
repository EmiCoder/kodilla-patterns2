package com.kodilla.kodillapatterns2.facade;

import com.kodilla.kodillapatterns2.facade.api.OrderDto;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class WatcherFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(WatcherFacade.class);

    @Before("execution(* com.kodilla.kodillapatterns2.facade.api.OrderFacade.processOrder(..)) && args(order, userId) && target(object)")
    public void logEvent(final OrderDto order, final Long userId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + " Args: order - " + order + ", userId - " + userId);
    }
}
