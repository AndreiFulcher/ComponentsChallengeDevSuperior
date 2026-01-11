package com.desafiodevsuperior.aula.services;

import com.desafiodevsuperior.aula.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {
        return order.getBasic() * (1 - order.getDiscount() / 100.0) + shippingService.shipment(order);
    }
}

