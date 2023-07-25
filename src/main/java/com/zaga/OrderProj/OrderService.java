package com.zaga.OrderProj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepo repo;

    public OrderEntity createOrderDetails(OrderEntity order) {
        OrderEntity details = repo.save(order);
        return details;
    }

    public OrderEntity getOrderDetails(Long id) {

        OrderEntity getDetails = repo.findById(id).orElse(null);
        return getDetails;

    }

}